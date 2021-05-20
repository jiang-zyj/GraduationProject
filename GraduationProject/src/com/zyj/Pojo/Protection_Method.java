package com.zyj.Pojo;

/**
 * @ClassName Protection_Method
 * @Auther: YaJun
 * @Date: 2021 - 04 - 01 - 16:22
 * @Description: com.zyj.Pojo
 * @version: 1.0
 */
public class Protection_Method {
    /*
    CREATE TABLE `protection_method` (
  `method_id` int NOT NULL AUTO_INCREMENT,
  `method_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `strategy_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`method_id`),
  KEY `method_name` (`method_name`),
  KEY `strategy_name` (`strategy_name`),
  CONSTRAINT `protection_method_ibfk_1` FOREIGN KEY (`strategy_name`) REFERENCES `protection_strategy` (`strategy_name`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
     */

    private Integer method_id;
    private String method_name;
    private String strategy_name;

    public Protection_Method() {

    }

    @Override
    public String toString() {
        return "Protection_Method{" +
                "method_id=" + method_id +
                ", method_name='" + method_name + '\'' +
                ", strategy_name='" + strategy_name + '\'' +
                '}';
    }

    public Integer getMethod_id() {
        return method_id;
    }

    public void setMethod_id(Integer method_id) {
        this.method_id = method_id;
    }

    public String getMethod_name() {
        return method_name;
    }

    public void setMethod_name(String method_name) {
        this.method_name = method_name;
    }

    public String getStrategy_name() {
        return strategy_name;
    }

    public void setStrategy_name(String strategy_name) {
        this.strategy_name = strategy_name;
    }
}
