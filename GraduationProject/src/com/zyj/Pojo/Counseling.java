package com.zyj.Pojo;

/**
 * @ClassName Counseling
 * @Auther: YaJun
 * @Date: 2021 - 04 - 22 - 15:16
 * @Description: com.zyj.Pojo
 * @version: 1.0
 */
public class Counseling {

    /*
     * CREATE TABLE `counseling` (
     *   `cs_id` int NOT NULL AUTO_INCREMENT,
     *   `cs_category` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
     *   PRIMARY KEY (`cs_id`) USING BTREE,
     *   KEY `counseling_category` (`cs_category`)
     * ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
     */

    private Integer cs_id;

    private String cs_category;

    public Integer getCs_id() {
        return cs_id;
    }

    public void setCs_id(Integer cs_id) {
        this.cs_id = cs_id;
    }

    public String getCs_category() {
        return cs_category;
    }

    public void setCs_category(String cs_category) {
        this.cs_category = cs_category;
    }

    public Counseling() {
    }

    @Override
    public String toString() {
        return "Counseling{" +
                "cs_id=" + cs_id +
                ", cs_category='" + cs_category + '\'' +
                '}';
    }
}
