package com.fonsoft.facediary.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;
    private String userPassword;
    private String userFacePassword;

    public User() {
    }

    public User(String userName, String userPassword, String userFacePassword) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userFacePassword = userFacePassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userFacePassword='" + userFacePassword + '\'' +
                '}';
    }
}
