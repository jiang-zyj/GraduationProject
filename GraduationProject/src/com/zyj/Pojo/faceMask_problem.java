package com.zyj.Pojo;

/**
 * @ClassName faceMask_problem
 * @Auther: YaJun
 * @Date: 2021 - 04 - 13 - 13:16
 * @Description: com.zyj.Pojo
 * @version: 1.0
 */
public class faceMask_problem {

    /*
     * CREATE TABLE `facemask_problem` (
     *   `fp_id` int NOT NULL AUTO_INCREMENT,
     *   `fp_question` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
     *   `d_doctorInfo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
     *   `fp_answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
     *   `fm_method` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
     *   PRIMARY KEY (`fp_id`) USING BTREE,
     *   KEY `d_doctorInfo` (`d_doctorInfo`),
     *   KEY `fm_method` (`fm_method`),
     *   CONSTRAINT `facemask_problem_ibfk_3` FOREIGN KEY (`d_doctorInfo`) REFERENCES `doctor` (`d_doctorInfo`),
     *   CONSTRAINT `facemask_problem_ibfk_4` FOREIGN KEY (`fm_method`) REFERENCES `use_facemask` (`fm_method`)
     * ) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
     */

    private Integer fp_id;

    private String fp_question;

    private String d_doctorInfo;

    private String fp_answer;

    private String fm_method;



    public Integer getFp_id() {
        return fp_id;
    }

    public void setFp_id(Integer fp_id) {
        this.fp_id = fp_id;
    }

    public String getFp_question() {
        return fp_question;
    }

    public void setFp_question(String fp_question) {
        this.fp_question = fp_question;
    }

    public String getD_doctorInfo() {
        return d_doctorInfo;
    }

    public void setD_doctorInfo(String d_doctorInfo) {
        this.d_doctorInfo = d_doctorInfo;
    }

    public String getFp_answer() {
        return fp_answer;
    }

    public void setFp_answer(String fp_answer) {
        this.fp_answer = fp_answer;
    }

    public String getFm_method() {
        return fm_method;
    }

    public void setFm_method(String fm_method) {
        this.fm_method = fm_method;
    }


    public faceMask_problem() {
    }

    @Override
    public String toString() {
        return "faceMask_problem{" +
                "fp_id=" + fp_id +
                ", fp_question='" + fp_question + '\'' +
                ", d_doctorInfo='" + d_doctorInfo + '\'' +
                ", fp_answer='" + fp_answer + '\'' +
                ", fm_method='" + fm_method + '\'' +
                '}';
    }
}
