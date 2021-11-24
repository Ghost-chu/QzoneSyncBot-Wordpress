package com.ghostchu.qzonesync;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class Emotion {

    @SerializedName("certified")
    private Integer certified;
    @SerializedName("cmtnum")
    private Integer cmtnum;
    @SerializedName("conlist")
    private List<ConlistDTO> conlist;
    @SerializedName("content")
    private String content;
    @SerializedName("createTime")
    private String createTime;
    @SerializedName("created_time")
    private Integer createdTime;
    @SerializedName("editMask")
    private Long editMask;
    @SerializedName("fwdnum")
    private Integer fwdnum;
    @SerializedName("has_more_con")
    private Integer hasMoreCon;
    @SerializedName("isEditable")
    private Integer isEditable;
    @SerializedName("issigin")
    private Integer issigin;
    @SerializedName("lbs")
    private LbsDTO lbs;
    @SerializedName("name")
    private String name;
    @SerializedName("pic_template")
    private String picTemplate;
    @SerializedName("right")
    private Integer right;
    @SerializedName("rt_sum")
    private Integer rtSum;
    @SerializedName("secret")
    private Integer secret;
    @SerializedName("source_appid")
    private String sourceAppid;
    @SerializedName("source_name")
    private String sourceName;
    @SerializedName("source_url")
    private String sourceUrl;
    @SerializedName("t1_source")
    private Integer t1Source;
    @SerializedName("t1_subtype")
    private Integer t1Subtype;
    @SerializedName("t1_termtype")
    private Integer t1Termtype;
    @SerializedName("tid")
    private String tid;
    @SerializedName("ugc_right")
    private Integer ugcRight;
    @SerializedName("uin")
    private Long uin;
    @SerializedName("wbid")
    private Integer wbid;

    @NoArgsConstructor
    @Data
    public static class LbsDTO {
        @SerializedName("id")
        private String id;
        @SerializedName("idname")
        private String idname;
        @SerializedName("name")
        private String name;
        @SerializedName("pos_x")
        private String posX;
        @SerializedName("pos_y")
        private String posY;
    }

    @NoArgsConstructor
    @Data
    public static class ConlistDTO {
        @SerializedName("con")
        private String con;
        @SerializedName("type")
        private Integer type;
    }
}
