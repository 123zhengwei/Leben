package com.example.administrator.myapplication;
public class St {
    private int userId;
    private String userTel;
    private String userPass;
    private String userNikename;
    private String userAge;
    private String userHeight;
    private String userWeight;

    public St(int userId, String userTel, String userPass) {
        this.userId = userId;
        this.userTel = userTel;
        this.userPass = userPass;
    }

    public int getId() {
        return userId;
    }

    public void setId(int userId) {
        this.userId = userId;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    @Override
    public String toString() {
        return "St{" +
                "userId=" + userId +
                ", userTel='" + userTel + '\'' +
                ", userPass='" + userPass + '\'' +
                '}';
    }
}