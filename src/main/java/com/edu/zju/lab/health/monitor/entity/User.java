package com.edu.zju.lab.health.monitor.entity;

/**
 * Created by Administrator on 2015/10/14.
 */
public class User {
    private int id;
    private String username;
    private String gender;
    private String password;
    private String tel;
    private String mail;

    public User(){}

    public User(int id, String username, String gender, String password, String tel, String mail) {
        this.id = id;
        this.username = username;
        this.gender = gender;
        this.password = password;
        this.tel = tel;
        this.mail = mail;
    }

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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
