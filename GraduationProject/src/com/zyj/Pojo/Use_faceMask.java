package com.zyj.Pojo;

/**
 * @ClassName Use_faceMask
 * @Auther: YaJun
 * @Date: 2021 - 04 - 11 - 11:53
 * @Description: com.zyj.Pojo
 * @version: 1.0
 */
public class Use_faceMask {
    /*
     * CREATE TABLE `use_facemask` (
     *   `fm_id` int NOT NULL AUTO_INCREMENT,
     *   `fm_method` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
     *   PRIMARY KEY (`fm_id`) USING BTREE,
     *   KEY `facemask_method` (`fm_method`)
     * ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
     */

    private Integer fm_id;

    private String fm_method;

    public Integer getFm_id() {
        return fm_id;
    }

    public void setFm_id(Integer fm_id) {
        this.fm_id = fm_id;
    }

    public String getFm_method() {
        return fm_method;
    }

    public void setFm_method(String fm_method) {
        this.fm_method = fm_method;
    }

    public Use_faceMask() {
    }

    @Override
    public String toString() {
        return "Use_faceMask{" +
                "fm_id=" + fm_id +
                ", fm_method='" + fm_method + '\'' +
                '}';
    }
}
