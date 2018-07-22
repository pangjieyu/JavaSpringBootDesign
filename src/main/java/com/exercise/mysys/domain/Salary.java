package com.exercise.mysys.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_Salary")
public class Salary implements Serializable {
    private static final long serialVersionUID = 8283950216116626180L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long Sid;
    private String name;

    // 与 Address 的关联
    private Long userId;

    public Salary() {
        super();
    }

    public Salary(String name, Long userId) {
        super();
        this.name = name;
        this.userId = userId;
    }

    // getter, setter

    @Override
    public String toString() {
        return String.format("Salary [Sid=%d, name=%s, userid=%s]", Sid, name, userId);
    }

}
