package com.exercise.mysys.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @ProjectName 食品企业订货销售系统
 * @Author 朱向阳
 * @Date 2018/7/20 16:11
 * @Description: TODO
 */
@Entity
public class InKu {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //编号（主键）
    private Long id;
    //商品编号（主键）
    private Long good_id;
    //员工编号（主键）
    private Long employee_id;
    //商品数量
    private Integer number;
    //入库日期
    private Date in_date;

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

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getIn_date() {
        return in_date;
    }

    public void setIn_date(Date in_date) {
        this.in_date = in_date;
    }
}
