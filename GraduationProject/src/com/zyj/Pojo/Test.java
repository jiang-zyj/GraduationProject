package com.zyj.Pojo;

import java.util.Date;

/**
 * @ClassName Test
 * @Auther: YaJun
 * @Date: 2021 - 04 - 29 - 16:37
 * @Description: com.zyj.Pojo
 * @version: 1.0
 */
public class Test {

    /*
     * create table t_user(
     * 		t_id	int primary key auto_increment,
     * 		t_name varchar(255),
     * 		t_pic varchar(255),
     * 		t_time date
     * 	);
     */

    private Integer t_id;
    private String t_name;

    private String t_pic;
    private Date t_time;

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_pic() {
        return t_pic;
    }

    public void setT_pic(String t_pic) {
        this.t_pic = t_pic;
    }

    public Date getT_time() {
        return t_time;
    }

    public void setT_time(Date t_time) {
        this.t_time = t_time;
    }

    public Test() {
    }

    @Override
    public String toString() {
        return "Test{" +
                "t_id=" + t_id +
                ", t_name='" + t_name + '\'' +
                ", t_pic='" + t_pic + '\'' +
                ", t_time=" + t_time +
                '}';
    }
}
