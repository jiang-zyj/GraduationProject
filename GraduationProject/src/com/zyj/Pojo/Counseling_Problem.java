package com.zyj.Pojo;

/**
 * @ClassName Counseling_Problem
 * @Auther: YaJun
 * @Date: 2021 - 04 - 13 - 21:13
 * @Description: com.zyj.Pojo
 * @version: 1.0
 */
public class Counseling_Problem {

    /*
     * CREATE TABLE `counseling_problem` (
     *   `cp_id` int NOT NULL AUTO_INCREMENT,
     *   `cp_problem` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
     *   `d_doctorInfo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
     *   `cp_answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
     *   `cs_category` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
     *   PRIMARY KEY (`cp_id`),
     *   KEY `d_doctorInfo` (`d_doctorInfo`),
     *   KEY `cs_category` (`cs_category`),
     *   CONSTRAINT `counseling_problem_ibfk_3` FOREIGN KEY (`d_doctorInfo`) REFERENCES `doctor` (`d_doctorInfo`),
     *   CONSTRAINT `counseling_problem_ibfk_4` FOREIGN KEY (`cs_category`) REFERENCES `counseling` (`cs_category`)
     * ) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
     */

    private Integer cp_id;

    private String cp_problem;

    private String d_doctorInfo;

    private String cp_answer;

    private String cs_category;

    public Integer getCp_id() {
        return cp_id;
    }

    public void setCp_id(Integer cp_id) {
        this.cp_id = cp_id;
    }

    public String getCp_problem() {
        return cp_problem;
    }

    public void setCp_problem(String cp_problem) {
        this.cp_problem = cp_problem;
    }

    public String getD_doctorInfo() {
        return d_doctorInfo;
    }

    public void setD_doctorInfo(String d_doctorInfo) {
        this.d_doctorInfo = d_doctorInfo;
    }

    public String getCp_answer() {
        return cp_answer;
    }

    public void setCp_answer(String cp_answer) {
        this.cp_answer = cp_answer;
    }

    public String getCs_category() {
        return cs_category;
    }

    public void setCs_category(String cs_category) {
        this.cs_category = cs_category;
    }

    public Counseling_Problem() {
    }

    @Override
    public String toString() {
        return "Counseling_Problem{" +
                "cp_id=" + cp_id +
                ", cp_problem='" + cp_problem + '\'' +
                ", d_doctorInfo='" + d_doctorInfo + '\'' +
                ", cp_answer='" + cp_answer + '\'' +
                ", cs_category='" + cs_category + '\'' +
                '}';
    }
}
