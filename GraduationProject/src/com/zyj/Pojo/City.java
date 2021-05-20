package com.zyj.Pojo;

/**
 * @ClassName City
 * @Auther: YaJun
 * @Date: 2021 - 03 - 30 - 15:08
 * @Description: com.zyj.Pojo
 * @version: 1.0
 */
public class City {
    /*
    CREATE TABLE `city` (
  `cid` int NOT NULL AUTO_INCREMENT,
  `cname` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`cid`) USING BTREE,
  UNIQUE KEY `cname_2` (`cname`),
  KEY `cname` (`cname`)
) ENGINE=InnoDB AUTO_INCREMENT=153 DEFAULT CHARSET=utf8;
     */

    private Integer cid;

    private String cname;

    public City() {
    }

    @Override
    public String toString() {
        return "City{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
