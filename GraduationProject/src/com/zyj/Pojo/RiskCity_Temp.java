package com.zyj.Pojo;

/**
 * @ClassName RiskCity_Temp
 * @Auther: YaJun
 * @Date: 2021 - 04 - 03 - 18:14
 * @Description: com.zyj.Pojo
 * @version: 1.0
 */
public class RiskCity_Temp {

    private Integer sumConfirmed;

    private String cname;

    public RiskCity_Temp() {
    }

    @Override
    public String toString() {
        return "RiskCity_Temp{" +
                "sumConfirmed=" + sumConfirmed +
                ", cname='" + cname + '\'' +
                '}';
    }

    public Integer getSumConfirmed() {
        return sumConfirmed;
    }

    public void setSumConfirmed(Integer sumConfirmed) {
        this.sumConfirmed = sumConfirmed;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
