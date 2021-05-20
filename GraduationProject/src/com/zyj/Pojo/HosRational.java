package com.zyj.Pojo;

/**
 * @ClassName HosRational
 * @Auther: YaJun
 * @Date: 2021 - 03 - 30 - 17:45
 * @Description: com.zyj.Pojo
 * @version: 1.0
 */
public class HosRational {

    /*
    CREATE TABLE `hospitalize_rational` (
  `h_id` int NOT NULL AUTO_INCREMENT,
  `h_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`h_id`) USING BTREE,
  KEY `hospitalize_name` (`h_name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
     */

    private Integer h_id;

    private String h_name;

    public HosRational() {
    }

    @Override
    public String toString() {
        return "HosRational{" +
                "h_id=" + h_id +
                ", h_name='" + h_name + '\'' +
                '}';
    }

    public Integer getH_id() {
        return h_id;
    }

    public void setH_id(Integer h_id) {
        this.h_id = h_id;
    }

    public String getH_name() {
        return h_name;
    }

    public void setH_name(String h_name) {
        this.h_name = h_name;
    }
}
