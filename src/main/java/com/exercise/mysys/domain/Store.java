package com.exercise.mysys.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
    //存储数量
    private Integer numble;
    //存放位置
    private String position;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumble() {
        return numble;
    }

    public void setNumble(Integer numble) {
        this.numble = numble;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
