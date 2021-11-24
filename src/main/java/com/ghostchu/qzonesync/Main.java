package com.ghostchu.qzonesync;

import com.google.gson.Gson;
import de.leonhard.storage.LightningBuilder;
import de.leonhard.storage.Yaml;
import de.leonhard.storage.internal.settings.ConfigSettings;
import de.leonhard.storage.internal.settings.ReloadSettings;
import org.chobit.wp.WordPress;
import org.chobit.wp.model.request.PostRequest;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger("QzoneSync");
    private static final Yaml config = LightningBuilder
            .fromFile(new File("config.yml"))
            .setReloadSettings(ReloadSettings.INTELLIGENT)
            .setConfigSettings(ConfigSettings.PRESERVE_COMMENTS)
            .createYaml();

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        LOGGER.info("Qzone Sync Bot - Powered by QZone Python API; Made by Ghost_chu; Made with ❤");
        LOGGER.info("Setting up workspace...");


        LOGGER.info("Executing external python script: main.py");

        StringBuilder builder = new StringBuilder();
        Process proc;
        try {
            proc = Runtime.getRuntime().exec(config.getOrSetDefault("shell","python3 main.py"));
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                builder.append(line).append("\n");
            }
            in.close();
            proc.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        LOGGER.info("Executing external python script: main.py");
        String response = new String(Base64.getDecoder().decode(builder.toString().trim()));
        LOGGER.info("Python response: " + response);

        if (checkBeenUpdated(response)) {
            LOGGER.info("Qzone Sync detected new emotion published, syncing...");
            try {
                int id = publishToWordpress(response);
                LOGGER.info("Published on Wordpress with id: "+id);
            }catch (PostNotSendException exception){
                LOGGER.warning("Publish skipping: "+exception.getMessage());
            }
        }else{
            LOGGER.info("No updates found.");
        }

    }

    private boolean checkBeenUpdated(String newResponse) throws IOException {
        File lastSyncFile = new File("last.txt");
        if (!lastSyncFile.exists())
            lastSyncFile.createNewFile();
        String lastSyncContent = Files.readString(lastSyncFile.toPath());
        if (newResponse.equals(lastSyncContent)) {
            return false;
        }
        Files.writeString(lastSyncFile.toPath(), newResponse);
        return true;
    }


    public int publishToWordpress(String json) throws PostNotSendException {
        String rpc = config.getOrSetDefault("rpc", "https://www.ghostchu.com/xmlrpc.php");
        String username = config.getOrSetDefault("username", "syncbot");
        String password = config.getOrSetDefault("password", "PASSWORD");
        String titlePrefix = config.getOrSetDefault("title-prefix", "[说说同步]");
        String postType = config.getOrSetDefault("post-type", "shuoshuo");
        int mode = config.getOrSetDefault("sync-mode", 0); // 0-黑名单模式 1-白名单模式
        String modeKeyword =  config.getOrSetDefault("sync-mode-keyword", "[wp-sync-skip]"); // 0-黑名单模式 1-白名单模式

        System.out.println(json);
        Emotion emotion = new Gson().fromJson(json, Emotion.class);
        if(mode == 0){
            if(emotion.getContent().contains(modeKeyword)){
                throw new PostNotSendException("Skip keyword detected.");
            }
        }else if(mode == 1){
            if(!emotion.getContent().contains(modeKeyword)){
                throw new PostNotSendException("Sync keyword detected.");
            }
        }
        PostContainer postContainer = new PostContainer(emotion);

        PostRequest post = new PostRequest();
        post.setPostTitle(titlePrefix + postContainer.getTitle());
        if(postContainer.getForwards() != null){
            post.setPostContent(postContainer.getContent()+"\n\n"+postContainer.getForwards());
        }else{
            post.setPostContent(postContainer.getContent());
        }
        LOGGER.info("内容："+post.getPostContent());
        post.setPostType(postType);
        post.setPostName(postContainer.getTitle());
        WordPress wp = new WordPress(rpc, username, password);
        return wp.newPost(post);
    }


    static class PostContainer {
        private String title;
        private String content;
        @Nullable
        private String forwards;

        public PostContainer(Emotion emotion) {
            parseTitleAndContent(emotion.getContent());
            forwards = readForwardEmotion(emotion.getOrigin());
        }

        public String getForwards() {
            if(forwards == null || forwards.isEmpty()){
                return null;
            }
            return "转发自：\n"+forwards;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }


        public String readForwardEmotion(Emotion.OriginDTO emotion){
            StringBuilder builder = new StringBuilder();
            builder.append(emotion.getNickname()).append(": ").append(emotion.getContent());
            if(emotion.getOrigin() != null){
                builder.append("\n\t").append(readForwardEmotion(emotion.getOrigin()).replace("\t","\t\t"));
            }
            return builder.toString();
        }
        private void parseTitleAndContent(String body) {
            String[] lines = body.split("\n", 2);

            if(lines.length < 2){
                if(lines[0].length() > 20){
                    this.title = lines[0].substring(20);
                    this.content = body;
                }else{
                    this.title = body;
                    this.content = body;
                }
            }else{
                if(lines[0].length() > 20){
                    this.title = lines[0].substring(20);
                }else{
                    this.title = lines[0];
                }
                this.content = lines[1];
            }
           System.out.println(Arrays.toString(lines));
        }
    }
}
