package com.utopia.demo.dto;

public class LoginParam {

    private String captcha;

    private String username;

    private String password;

    @Override
    public String toString() {
        return "LoginParam{" +
                "captcha='" + captcha + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
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
}
