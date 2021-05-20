package com.zyj.Pojo;

/**
 * @ClassName Protection_Problem
 * @Auther: YaJun
 * @Date: 2021 - 04 - 01 - 17:18
 * @Description: com.zyj.Pojo
 * @version: 1.0
 */
public class Protection_Problem {

    /*
    CREATE TABLE `protection_problem` (
  `problem_id` int NOT NULL AUTO_INCREMENT,
  `problem_question` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `d_doctorInfo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `problem_answer` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `method_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`problem_id`),
  KEY `d_doctorInfo` (`d_doctorInfo`),
  KEY `method_name` (`method_name`),
  CONSTRAINT `protection_problem_ibfk_3` FOREIGN KEY (`d_doctorInfo`) REFERENCES `doctor` (`d_doctorInfo`),
  CONSTRAINT `protection_problem_ibfk_4` FOREIGN KEY (`method_name`) REFERENCES `protection_method` (`method_name`)
) ENGINE=InnoDB AUTO_INCREMENT=548 DEFAULT CHARSET=utf8;
     */
    private Integer problem_id;
    private String problem_question;
    private String d_doctorInfo;
    private String problem_answer;
    private String method_name;

    public Protection_Problem() {
    }

    @Override
    public String toString() {
        return "Protection_Problem{" +
                "problem_id=" + problem_id +
                ", problem_question='" + problem_question + '\'' +
                ", d_doctorInfo='" + d_doctorInfo + '\'' +
                ", problem_answer='" + problem_answer + '\'' +
                ", method_name='" + method_name + '\'' +
                '}';
    }

    public Integer getProblem_id() {
        return problem_id;
    }

    public void setProblem_id(Integer problem_id) {
        this.problem_id = problem_id;
    }

    public String getProblem_question() {
        return problem_question;
    }

    public void setProblem_question(String problem_question) {
        this.problem_question = problem_question;
    }

    public String getD_doctorInfo() {
        return d_doctorInfo;
    }

    public void setD_doctorInfo(String d_doctorInfo) {
        this.d_doctorInfo = d_doctorInfo;
    }

    public String getProblem_answer() {
        return problem_answer;
    }

    public void setProblem_answer(String problem_answer) {
        this.problem_answer = problem_answer;
    }

    public String getMethod_name() {
        return method_name;
    }

    public void setMethod_name(String method_name) {
        this.method_name = method_name;
    }
}
