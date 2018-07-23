package com.exercise.mysys.domain;

import java.io.Serializable;

public class ViewInfo implements Serializable {

    private static final long serialVersionUID = -6347911007178390219L;

    private UserInfo userInfo;
    private Address address;
    private Salary salary;

    public ViewInfo() {

    }

    public ViewInfo(UserInfo userInfo) {
        Address address = new Address();
        Salary salary = new Salary();
        this.userInfo = userInfo;
        this.address = address;
        this.salary = salary;
    }

    public ViewInfo(Address address) {
        UserInfo userInfo = new UserInfo();
        Salary salary = new Salary();
        this.userInfo = userInfo;
        this.address = address;
        this.salary = salary;
    }

    public  ViewInfo(Salary salary){
        UserInfo userInfo = new UserInfo();
        Address address = new Address();
        this.address = address;
        this.userInfo = userInfo;
        this.salary = salary;
    }
    public ViewInfo(UserInfo userInfo, Address address,Salary salary) {
        this.userInfo = userInfo;
        this.address = address;
        this.salary = salary;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public Address getAddress() {
        return address;
    }

    public Salary getSalary() {
        return salary;
    }

    // getter, setter

}