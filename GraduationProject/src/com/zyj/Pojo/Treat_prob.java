package com.zyj.Pojo;

/**
 * @ClassName Treat_prob
 * @Auther: YaJun
 * @Date: 2021 - 03 - 30 - 15:42
 * @Description: com.zyj.Pojo
 * @version: 1.0
 */
public class Treat_prob {

    /*
   CREATE TABLE `hospitalize_question` (
  `treat_id` int NOT NULL AUTO_INCREMENT,
  `treat_prob` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `d_doctorInfo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `treat_ans` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `h_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`treat_id`) USING BTREE,
  KEY `d_doctorInfo` (`d_doctorInfo`),
  KEY `h_name` (`h_name`),
  CONSTRAINT `hospitalize_question_ibfk_3` FOREIGN KEY (`d_doctorInfo`) REFERENCES `doctor` (`d_doctorInfo`),
  CONSTRAINT `hospitalize_question_ibfk_4` FOREIGN KEY (`h_name`) REFERENCES `hospitalize_rational` (`h_name`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
     */

    private int treat_id;
    private String treat_prob;
    private String d_doctorInfo;
    private String treat_ans;
    private String h_name;

    public Treat_prob() {
    }

    @Override
    public String toString() {
        return "Treat_prob{" +
                "treat_id=" + treat_id +
                ", treat_prob='" + treat_prob + '\'' +
                ", d_doctorInfo='" + d_doctorInfo + '\'' +
                ", treat_ans='" + treat_ans + '\'' +
                ", h_name='" + h_name + '\'' +
                '}';
    }

    public int getTreat_id() {
        return treat_id;
    }

    public void setTreat_id(int treat_id) {
        this.treat_id = treat_id;
    }

    public String getTreat_prob() {
        return treat_prob;
    }

    public void setTreat_prob(String treat_prob) {
        this.treat_prob = treat_prob;
    }

    public String getD_doctorInfo() {
        return d_doctorInfo;
    }

    public void setD_doctorInfo(String d_doctorInfo) {
        this.d_doctorInfo = d_doctorInfo;
    }

    public String getTreat_ans() {
        return treat_ans;
    }

    public void setTreat_ans(String treat_ans) {
        this.treat_ans = treat_ans;
    }

    public String getH_name() {
        return h_name;
    }

    public void setH_name(String h_name) {
        this.h_name = h_name;
    }
}
