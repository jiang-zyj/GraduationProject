package com.zyj.Pojo;

/**
 * @ClassName Scenic
 * @Auther: YaJun
 * @Date: 2021 - 03 - 30 - 9:13
 * @Description: com.zyj.Pojo
 * @version: 1.0
 */
public class Scenic {


    /*
    CREATE TABLE `scenic` (
  `sid` int NOT NULL AUTO_INCREMENT,
  `scenic_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `scenic_pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `scenic_addr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `business_hours` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `scenic_opened` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `scenic_flag` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `cname` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`sid`),
  KEY `cname` (`cname`),
  CONSTRAINT `scenic_ibfk_1` FOREIGN KEY (`cname`) REFERENCES `city` (`cname`)
) ENGINE=InnoDB AUTO_INCREMENT=468 DEFAULT CHARSET=utf8;
     */

    private Integer sid;
    private String scenic_name;
    private String scenic_pic;
    private String scenic_addr;
    private String business_hours;
    private String scenic_opened;
    private String scenic_flag;
    private String cname;


    public Scenic() {

    }

    @Override
    public String toString() {
        return "Scenic{" +
                "sid=" + sid +
                ", scenic_name='" + scenic_name + '\'' +
                ", scenic_pic='" + scenic_pic + '\'' +
                ", scenic_addr='" + scenic_addr + '\'' +
                ", business_hours='" + business_hours + '\'' +
                ", scenic_opened='" + scenic_opened + '\'' +
                ", scenic_flag='" + scenic_flag + '\'' +
                ", cname='" + cname + '\'' +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getScenic_name() {
        return scenic_name;
    }

    public void setScenic_name(String scenic_name) {
        this.scenic_name = scenic_name;
    }

    public String getScenic_pic() {
        return scenic_pic;
    }

    public void setScenic_pic(String scenic_pic) {
        this.scenic_pic = scenic_pic;
    }

    public String getScenic_addr() {
        return scenic_addr;
    }

    public void setScenic_addr(String scenic_addr) {
        this.scenic_addr = scenic_addr;
    }

    public String getBusiness_hours() {
        return business_hours;
    }

    public void setBusiness_hours(String business_hours) {
        this.business_hours = business_hours;
    }

    public String getScenic_opened() {
        return scenic_opened;
    }

    public void setScenic_opened(String scenic_opened) {
        this.scenic_opened = scenic_opened;
    }

    public String getScenic_flag() {
        return scenic_flag;
    }

    public void setScenic_flag(String scenic_flag) {
        this.scenic_flag = scenic_flag;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
