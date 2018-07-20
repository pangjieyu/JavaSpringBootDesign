package com.exercise.mysys.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @ProjectName 食品企业订货销售系统
 * @Author 朱向阳
 * @Date 2018/7/20 16:20
 * @Description: 销毁单类
 */
@Entity
public class Destroy {
    @Id
    @GeneratedValue
    //编号（主键）
    private Long id;
    //商品编号（外键）
    private Long good_id;
    //商品数量
    private Integer number;
    //员工编号（外键）
    private Long employee_id;
    //销毁日期
    private Date destroy_date;

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

    public Date getDestroy_date() {
        return destroy_date;
    }

    public void setDestroy_date(Date destroy_date) {
        this.destroy_date = destroy_date;
    }
}
