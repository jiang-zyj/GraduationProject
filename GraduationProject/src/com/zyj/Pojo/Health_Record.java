package com.zyj.Pojo;

import java.util.Date;

/**
 * @ClassName Health_Record
 * @Auther: YaJun
 * @Date: 2021 - 04 - 03 - 20:42
 * @Description: com.zyj.Pojo
 * @version: 1.0
 */
public class Health_Record {

    /*
     * CREATE TABLE `healthrecord` (
     * `hr_id` int NOT NULL AUTO_INCREMENT,
     * `curr_time` date DEFAULT NULL COMMENT '打卡时间',
     * `health_status` double DEFAULT NULL COMMENT '记录打卡时用户的健康状态（新冠疫情值）',
     * `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
     * `cname` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
     * `uid` varchar(18) DEFAULT NULL,
     * PRIMARY KEY (`hr_id`) USING BTREE,
     * KEY `name` (`name`),
     * KEY `cname` (`cname`),
     * KEY `uid` (`uid`),
     * CONSTRAINT `healthrecord_ibfk_3` FOREIGN KEY (`name`) REFERENCES `user` (`name`),
     * CONSTRAINT `healthrecord_ibfk_4` FOREIGN KEY (`cname`) REFERENCES `city` (`cname`),
     * CONSTRAINT `healthrecord_ibfk_5` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
     * ) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
     */

    private Integer hr_id;

    private Date curr_time;

    private Double health_status;

    private String name;

    private String cname;

    private String uid;

    public Health_Record() {
    }

    @Override
    public String toString() {
        return "Health_Record{" +
                "hr_id=" + hr_id +
                ", curr_time=" + curr_time +
                ", health_status=" + health_status +
                ", name='" + name + '\'' +
                ", cname='" + cname + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }

    public Integer getHr_id() {
        return hr_id;
    }

    public void setHr_id(Integer hr_id) {
        this.hr_id = hr_id;
    }

    public Date getCurr_time() {
        return curr_time;
    }

    public void setCurr_time(Date curr_time) {
        this.curr_time = curr_time;
    }

    public Double getHealth_status() {
        return health_status;
    }

    public void setHealth_status(Double health_status) {
        this.health_status = health_status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
