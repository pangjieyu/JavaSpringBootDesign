package com.exercise.mysys.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_user")
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 8283950216116626180L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private int age;
    private String sex;
    private String email;

    // 与 Address 的关联
    private Long addressId;

    public UserInfo() {
        super();
    }

    public UserInfo(String name, int age, String sex, String email, Long addressId) {
        super();
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.email = email;
        this.addressId = addressId;
    }

    // getter, setter

    public Long getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return String.format("UserInfo [userId=%d, name=%s, age=%s, sex=%s, email=%s]", userId, name, age, sex, email);
    }

}