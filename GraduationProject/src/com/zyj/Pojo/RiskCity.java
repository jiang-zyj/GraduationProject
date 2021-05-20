package com.zyj.Pojo;

/**
 * @ClassName RiskCity
 * @Auther: YaJun
 * @Date: 2021 - 04 - 03 - 18:19
 * @Description: com.zyj.Pojo
 * @version: 1.0
 */
public class RiskCity {

    /*
    CREATE TABLE `risk_city` (
  `risk_id` int NOT NULL AUTO_INCREMENT,
  `cname` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `risk_desc` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`risk_id`),
  KEY `cname` (`cname`),
  CONSTRAINT `risk_city_ibfk_1` FOREIGN KEY (`cname`) REFERENCES `city` (`cname`)
) ENGINE=InnoDB AUTO_INCREMENT=906 DEFAULT CHARSET=utf8;
     */

    private Integer risk_id;
    private String cname;
    private String risk_desc;

    public RiskCity() {
    }

    @Override
    public String toString() {
        return "RiskCity{" +
                "risk_id=" + risk_id +
                ", cname='" + cname + '\'' +
                ", risk_desc='" + risk_desc + '\'' +
                '}';
    }

    public Integer getRisk_id() {
        return risk_id;
    }

    public void setRisk_id(Integer risk_id) {
        this.risk_id = risk_id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getRisk_desc() {
        return risk_desc;
    }

    public void setRisk_desc(String risk_desc) {
        this.risk_desc = risk_desc;
    }
}
