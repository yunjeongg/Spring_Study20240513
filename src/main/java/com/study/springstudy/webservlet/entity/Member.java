package com.study.springstudy.webservlet.entity;

public class Member {

    private String account;
    private String password;
    private String userName;

    public Member(String account, String password, String userName) {
        this.account = account;
        this.password = password;
        this.userName = userName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
