package com.zyj.Pojo;

import java.util.Date;

/**
 * @ClassName COVID19_Data
 * @Auther: YaJun
 * @Date: 2021 - 04 - 13 - 18:08
 * @Description: com.zyj.Pojo
 * @version: 1.0
 */
public class COVID19_Data {

    /*
     * CREATE TABLE `covid19_data` (
     *   `COVID_ID` int NOT NULL AUTO_INCREMENT,
     *   `CountryOrRegion` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
     *   `Last_Update` date DEFAULT NULL,
     *   `Confirmed` int DEFAULT NULL,
     *   `Deaths` int DEFAULT NULL,
     *   `Recovered` int DEFAULT NULL,
     *   `Increment_Confirmed` int DEFAULT NULL,
     *   `Increment_Deaths` int DEFAULT NULL,
     *   `Increment_Recovered` int DEFAULT NULL,
     *   `cname` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
     *   PRIMARY KEY (`COVID_ID`),
     *   KEY `cname` (`cname`),
     *   CONSTRAINT `covid19_data_ibfk_1` FOREIGN KEY (`cname`) REFERENCES `city` (`cname`)
     * ) ENGINE=InnoDB AUTO_INCREMENT=993 DEFAULT CHARSET=utf8;
     */

    private Integer covid_id;

    private String countryOrRegion;

    private Date last_Update;

    private Integer confirmed;

    private Integer deaths;

    private Integer recovered;

    private Integer increment_Confirmed;

    private Integer increment_Deaths;

    private Integer increment_Recovered;

    private String cname;

    private Integer confirmedSum;

    private Integer increment_ConfirmedSum;

    private Integer deathsSum;

    private Integer increment_DeathsSum;

    private Integer recoveredSum;

    private Integer increment_RecoveredSum;

    private String cityConfirmedSum;

    public String getCityConfirmedSum() {
        return cityConfirmedSum;
    }

    public void setCityConfirmedSum(String cityConfirmedSum) {
        this.cityConfirmedSum = cityConfirmedSum;
    }

    public Integer getIncrement_DeathsSum() {
        return increment_DeathsSum;
    }

    public void setIncrement_DeathsSum(Integer increment_DeathsSum) {
        this.increment_DeathsSum = increment_DeathsSum;
    }

    public Integer getRecoveredSum() {
        return recoveredSum;
    }

    public void setRecoveredSum(Integer recoveredSum) {
        this.recoveredSum = recoveredSum;
    }

    public Integer getIncrement_RecoveredSum() {
        return increment_RecoveredSum;
    }

    public void setIncrement_RecoveredSum(Integer increment_RecoveredSum) {
        this.increment_RecoveredSum = increment_RecoveredSum;
    }

    public Integer getDeathsSum() {
        return deathsSum;
    }

    public void setDeathsSum(Integer deathsSum) {
        this.deathsSum = deathsSum;
    }

    public Integer getIncrement_ConfirmedSum() {
        return increment_ConfirmedSum;
    }

    public void setIncrement_ConfirmedSum(Integer increment_ConfirmedSum) {
        this.increment_ConfirmedSum = increment_ConfirmedSum;
    }

    public Integer getConfirmedSum() {
        return confirmedSum;
    }

    public void setConfirmedSum(Integer confirmedSum) {
        this.confirmedSum = confirmedSum;
    }

    public Integer getCovid_id() {
        return covid_id;
    }

    public void setCovid_id(Integer covid_id) {
        this.covid_id = covid_id;
    }

    public String getCountryOrRegion() {
        return countryOrRegion;
    }

    public void setCountryOrRegion(String countryOrRegion) {
        this.countryOrRegion = countryOrRegion;
    }

    public Date getLast_Update() {
        return last_Update;
    }

    public void setLast_Update(Date last_Update) {
        this.last_Update = last_Update;
    }

    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getIncrement_Confirmed() {
        return increment_Confirmed;
    }

    public void setIncrement_Confirmed(Integer increment_Confirmed) {
        this.increment_Confirmed = increment_Confirmed;
    }

    public Integer getIncrement_Deaths() {
        return increment_Deaths;
    }

    public void setIncrement_Deaths(Integer increment_Deaths) {
        this.increment_Deaths = increment_Deaths;
    }

    public Integer getIncrement_Recovered() {
        return increment_Recovered;
    }

    public void setIncrement_Recovered(Integer increment_Recovered) {
        this.increment_Recovered = increment_Recovered;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public COVID19_Data() {
    }

    @Override
    public String toString() {
        return "COVID19_Data{" +
                "covid_id=" + covid_id +
                ", countryOrRegion='" + countryOrRegion + '\'' +
                ", last_Update=" + last_Update +
                ", confirmed=" + confirmed +
                ", deaths=" + deaths +
                ", recovered=" + recovered +
                ", increment_Confirmed=" + increment_Confirmed +
                ", increment_Deaths=" + increment_Deaths +
                ", increment_Recovered=" + increment_Recovered +
                ", cname='" + cname + '\'' +
                ", confirmedSum=" + confirmedSum +
                ", increment_ConfirmedSum=" + increment_ConfirmedSum +
                ", deathsSum=" + deathsSum +
                ", increment_DeathsSum=" + increment_DeathsSum +
                ", recoveredSum=" + recoveredSum +
                ", increment_RecoveredSum=" + increment_RecoveredSum +
                ", cityConfirmedSum='" + cityConfirmedSum + '\'' +
                '}';
    }
}
