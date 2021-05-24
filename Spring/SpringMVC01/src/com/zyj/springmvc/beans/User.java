package com.zyj.springmvc.beans;

/**
 * @ClassName User
 * @Auther: YaJun
 * @Date: 2021 - 04 - 10 - 11:00
 * @Description: com.zyj.springmvc.beans
 * @version: 1.0
 */
public class User {

    private String username;

    private String password;

    private String email;

    private Integer gender;

    private Address address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", address=" + address +
                '}';
    }
}
