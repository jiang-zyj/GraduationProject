package com.zyj.Pojo;

/**
 * @ClassName Protection_Strategy
 * @Auther: YaJun
 * @Date: 2021 - 04 - 01 - 15:46
 * @Description: com.zyj.Pojo
 * @version: 1.0
 */
public class Protection_Strategy {

    /*
     * CREATE TABLE `protection_strategy` (
     *   `strategy_id` int NOT NULL AUTO_INCREMENT,
     *   `strategy_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
     *   PRIMARY KEY (`strategy_id`),
     *   KEY `strategy_name` (`strategy_name`)
     * ) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
     */
    private Integer strategy_id;

    private String strategy_name;

    public Protection_Strategy() {
    }

    @Override
    public String toString() {
        return "Protection_Strategy{" +
                "strategy_id=" + strategy_id +
                ", strategy_name='" + strategy_name + '\'' +
                '}';
    }

    public Integer getStrategy_id() {
        return strategy_id;
    }

    public void setStrategy_id(Integer strategy_id) {
        this.strategy_id = strategy_id;
    }

    public String getStrategy_name() {
        return strategy_name;
    }

    public void setStrategy_name(String strategy_name) {
        this.strategy_name = strategy_name;
    }
}
