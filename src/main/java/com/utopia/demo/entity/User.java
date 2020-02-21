package com.utopia.demo.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User extends AbstractEntity{

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = true)
    private String password;

    @Column
    private String phone;

    @Column
    private String mail;

    @Column
    private String icon;

    @OneToOne
    private Role role;


    public User() {

    }

    public User(String username, String password, String phone, String mail) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.mail = mail;
    }
    public User(String username, String password, String phone, String mail, String icon) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.mail = mail;
        this.icon = icon;
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", icon='" + icon + '\'' +
                ", role=" + role +
                '}';
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
