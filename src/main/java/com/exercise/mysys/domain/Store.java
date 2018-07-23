package com.exercise.mysys.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @ProjectName 食品企业订货销售系统
 * @Author 朱向阳
 * @Date 2018/7/20 15:58
 * @Description: 库存类
 */
@Entity
public class Store {
    @Id
    @GeneratedValue
    //商品编号（主键）
    private Long id;
    //商品编号
    private Long good_id;
    //存储数量
    private Integer number;
    //存放位置
    private String position;
    //批号
    private Long in_id;
    //入库时间
    private Date in_time;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getIn_id() {
        return in_id;
    }

    public void setIn_id(Long in_id) {
        this.in_id = in_id;
    }

    public Date getIn_time() {
        return in_time;
    }

    public void setIn_time(Date in_time) {
        this.in_time = in_time;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getGood_id() {
        return good_id;
    }

    public void setGood_id(Long good_id) {
        this.good_id = good_id;
    }
}
