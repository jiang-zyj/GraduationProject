package com.zyj.Pojo;

/**
 * @ClassName Health_Code
 * @Auther: YaJun
 * @Date: 2021 - 04 - 03 - 22:35
 * @Description: com.zyj.Pojo
 * @version: 1.0
 */
public class Health_Code {

    /*
     * CREATE TABLE `health_code` (
     *   `code_id` int NOT NULL AUTO_INCREMENT,
     *   `code_status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
     *   `uid` char(18) DEFAULT NULL,
     *   PRIMARY KEY (`code_id`),
     *   KEY `uid` (`uid`),
     *   CONSTRAINT `health_code_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
     * ) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
     */

    private Integer code_id;

    private String code_status;

    private String uid;

    public Health_Code() {
    }

    @Override
    public String toString() {
        return "Health_Code{" +
                "code_id=" + code_id +
                ", code_status='" + code_status + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }

    public Integer getCode_id() {
        return code_id;
    }

    public void setCode_id(Integer code_id) {
        this.code_id = code_id;
    }

    public String getCode_status() {
        return code_status;
    }

    public void setCode_status(String code_status) {
        this.code_status = code_status;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
