package com.exercise.mysys.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @ProjectName 食品企业订货销售系统
 * @Author 朱向阳
 * @Date 2018/7/20 15:06
 * @Description: 生产计划类
 */
@Entity
public class ManufacturePlan {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //编号（主键）
    private Long id;
    //商品编号（外键）
    private Long good_id;
    //商品数量
    private Integer number;
    //员工编号（外键）
    private Long employee_id;
    //是否有效
    private Boolean effective;
    //金额（生产所以要的费用）
    private Integer money;
    //计划生产日期
    private Date manufacture_date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGood_id() {
        return good_id;
    }

    public void setGood_id(Long good_id) {
        this.good_id = good_id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public Boolean getEffective() {
        return effective;
    }

    public void setEffective(Boolean effective) {
        this.effective = effective;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Date getManufacture_date() {
        return manufacture_date;
    }

    public void setManufacture_date(Date manufacture_date) {
        this.manufacture_date = manufacture_date;
    }
}
