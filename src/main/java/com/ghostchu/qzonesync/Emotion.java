package com.ghostchu.qzonesync;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class Emotion {

    @SerializedName("comments")
    private List<?> comments;
    @SerializedName("shortcon")
    private String shortcon;
    @SerializedName("content")
    private String content;
    @SerializedName("ctime")
    private Integer ctime;
    @SerializedName("forwardn")
    private Integer forwardn;
    @SerializedName("location")
    private LocationDTO location;
    @SerializedName("nickname")
    private String nickname;
    @SerializedName("pictures")
    private List<?> pictures;
    @SerializedName("origin")
    private OriginDTO origin;
    @SerializedName("source")
    private String source;
    @SerializedName("tid")
    private String tid;
    @SerializedName("author")
    private Long author;
    @SerializedName("raw")
    private RawDTO raw;

    @NoArgsConstructor
    @Data
    public static class LocationDTO {
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
    public static class OriginDTO {
        @SerializedName("comments")
        private List<?> comments;
        @SerializedName("shortcon")
        private String shortcon;
        @SerializedName("content")
        private String content;
        @SerializedName("ctime")
        private CtimeDTO ctime;
        @SerializedName("forwardn")
        private Integer forwardn;
        @SerializedName("location")
        private LocationDTO location;
        @SerializedName("nickname")
        private String nickname;
        @SerializedName("pictures")
        private List<?> pictures;
        @SerializedName("origin")
        private OriginDTO origin;
        @SerializedName("source")
        private String source;
        @SerializedName("tid")
        private String tid;
        @SerializedName("author")
        private Long author;
        @SerializedName("raw")
        private RawDTO raw;

        @NoArgsConstructor
        @Data
        public static class CtimeDTO {
        }

        @NoArgsConstructor
        @Data
        public static class LocationDTO {
        }

        @NoArgsConstructor
        @Data
        public static class LikeDTO {
        }

        @NoArgsConstructor
        @Data
        public static class RawDTO {
            @SerializedName("commentlist")
            private List<?> commentlist;
            @SerializedName("content")
            private String content;
            @SerializedName("created_time")
            private CreatedTimeDTO createdTime;
            @SerializedName("name")
            private String name;
            @SerializedName("certified")
            private Integer certified;
            @SerializedName("cmtnum")
            private Integer cmtnum;
            @SerializedName("con")
            private ConDTO con;
            @SerializedName("createTime")
            private String createTime;
            @SerializedName("fwdnum")
            private Integer fwdnum;
            @SerializedName("has_more_con")
            private Integer hasMoreCon;
            @SerializedName("nosrc")
            private Integer nosrc;
            @SerializedName("source")
            private Integer source;
            @SerializedName("source_appid")
            private String sourceAppid;
            @SerializedName("source_name")
            private String sourceName;
            @SerializedName("source_url")
            private String sourceUrl;
            @SerializedName("sum")
            private Integer sum;
            @SerializedName("tid")
            private String tid;
            @SerializedName("uin")
            private Long uin;
            @SerializedName("uinname")
            private String uinname;
            @SerializedName("wbid")
            private Integer wbid;

            @NoArgsConstructor
            @Data
            public static class CreatedTimeDTO {
            }

            @NoArgsConstructor
            @Data
            public static class ConDTO {
                @SerializedName("conlist")
                private List<ConlistDTO> conlist;
                @SerializedName("content")
                private String content;

                @NoArgsConstructor
                @Data
                public static class ConlistDTO {
                    @SerializedName("con")
                    private String con;
                    @SerializedName("type")
                    private Integer type;
                }
            }
        }
    }

    @NoArgsConstructor
    @Data
    public static class RawDTO {
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
        @SerializedName("isEditable")
        private Integer isEditable;
        @SerializedName("issigin")
        private Integer issigin;
        @SerializedName("last_fwd")
        private List<LastFwdDTO> lastFwd;
        @SerializedName("lbs")
        private LbsDTO lbs;
        @SerializedName("name")
        private String name;
        @SerializedName("pic_template")
        private String picTemplate;
        @SerializedName("right")
        private Integer right;
        @SerializedName("rt_certified")
        private Integer rtCertified;
        @SerializedName("rt_cmtnum")
        private Integer rtCmtnum;
        @SerializedName("rt_con")
        private RtConDTO rtCon;
        @SerializedName("rt_createTime")
        private String rtCreatetime;
        @SerializedName("rt_fwdnum")
        private Integer rtFwdnum;
        @SerializedName("rt_has_more_con")
        private Integer rtHasMoreCon;
        @SerializedName("rt_nosrc")
        private Integer rtNosrc;
        @SerializedName("rt_source")
        private Integer rtSource;
        @SerializedName("rt_source_appid")
        private String rtSourceAppid;
        @SerializedName("rt_source_name")
        private String rtSourceName;
        @SerializedName("rt_source_url")
        private String rtSourceUrl;
        @SerializedName("rt_sum")
        private Integer rtSum;
        @SerializedName("rt_tid")
        private String rtTid;
        @SerializedName("rt_uin")
        private Long rtUin;
        @SerializedName("rt_uinname")
        private String rtUinname;
        @SerializedName("rt_wbid")
        private Integer rtWbid;
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
        @SerializedName("wc_flag")
        private Integer wcFlag;

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
        public static class RtConDTO {
            @SerializedName("conlist")
            private List<ConlistDTO> conlist;
            @SerializedName("content")
            private String content;

            @NoArgsConstructor
            @Data
            public static class ConlistDTO {
                @SerializedName("con")
                private String con;
                @SerializedName("type")
                private Integer type;
            }
        }

        @NoArgsConstructor
        @Data
        public static class ConlistDTO {
            @SerializedName("con")
            private String con;
            @SerializedName("type")
            private Integer type;
        }

        @NoArgsConstructor
        @Data
        public static class LastFwdDTO {
            @SerializedName("con")
            private String con;
            @SerializedName("type")
            private Integer type;
        }
    }
}
