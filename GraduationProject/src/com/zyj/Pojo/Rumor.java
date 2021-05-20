package com.zyj.Pojo;

/**
 * @ClassName Rumor
 * @Auther: YaJun
 * @Date: 2021 - 04 - 13 - 17:04
 * @Description: com.zyj.Pojo
 * @version: 1.0
 */
public class Rumor {

    /*
     * CREATE TABLE `Rumor` (
     *   `rid` int NOT NULL AUTO_INCREMENT,
     *   `r_question` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
     *   `r_shortAnswer` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
     *   `r_answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
     *   `d_doctorInfo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
     *   `t_ensure` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
     *   PRIMARY KEY (`rid`),
     *   KEY `t_ensure` (`t_ensure`),
     *   KEY `d_doctorInfo` (`d_doctorInfo`),
     *   CONSTRAINT `rumor_ibfk_1` FOREIGN KEY (`d_doctorInfo`) REFERENCES `doctor` (`d_doctorInfo`)
     * ) ENGINE=InnoDB AUTO_INCREMENT=619 DEFAULT CHARSET=utf8;
     */

    private Integer rid;

    private String r_question;

    private String r_shortAnswer;

    private String r_answer;

    private String d_doctorInfo;

    private String t_ensure;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getR_question() {
        return r_question;
    }

    public void setR_question(String r_question) {
        this.r_question = r_question;
    }

    public String getR_shortAnswer() {
        return r_shortAnswer;
    }

    public void setR_shortAnswer(String r_shortAnswer) {
        this.r_shortAnswer = r_shortAnswer;
    }

    public String getR_answer() {
        return r_answer;
    }

    public void setR_answer(String r_answer) {
        this.r_answer = r_answer;
    }

    public String getD_doctorInfo() {
        return d_doctorInfo;
    }

    public void setD_doctorInfo(String d_doctorInfo) {
        this.d_doctorInfo = d_doctorInfo;
    }

    public String getT_ensure() {
        return t_ensure;
    }

    public void setT_ensure(String t_ensure) {
        this.t_ensure = t_ensure;
    }

    public Rumor() {

    }

    @Override
    public String toString() {
        return "Rumor{" +
                "rid=" + rid +
                ", r_question='" + r_question + '\'' +
                ", r_shortAnswer='" + r_shortAnswer + '\'' +
                ", r_answer='" + r_answer + '\'' +
                ", d_doctorInfo='" + d_doctorInfo + '\'' +
                ", t_ensure='" + t_ensure + '\'' +
                '}';
    }
}
