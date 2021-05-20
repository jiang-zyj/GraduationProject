package com.zyj.Pojo;

/**
 * @ClassName Doctor
 * @Auther: YaJun
 * @Date: 2021 - 03 - 30 - 17:37
 * @Description: com.zyj.Pojo
 * @version: 1.0
 */
public class Doctor {

    /*
    CREATE TABLE `doctor` (
  `d_id` int NOT NULL AUTO_INCREMENT,
  `d_doctorInfo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`d_id`),
  KEY `d_doctorInfo` (`d_doctorInfo`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
     */

    private Integer d_id;
    private String d_doctorInfo;

    public Doctor() {
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "d_id=" + d_id +
                ", d_doctorInfo='" + d_doctorInfo + '\'' +
                '}';
    }

    public Integer getD_id() {
        return d_id;
    }

    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }

    public String getD_doctorInfo() {
        return d_doctorInfo;
    }

    public void setD_doctorInfo(String d_doctorInfo) {
        this.d_doctorInfo = d_doctorInfo;
    }
}
