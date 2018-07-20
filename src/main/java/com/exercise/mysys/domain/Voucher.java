package com.exercise.mysys.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @ProjectName 食品企业订货销售系统
 * @Author 朱向阳
 * @Date 2018/7/20 14:45
 * @Description: 凭证类
 */
@Entity
public class Voucher {
    @Id
    @GeneratedValue
    //编号（主键）
    private Long id;
    //客户编号（外键）
    private Long customer_id;
    //凭证类型（退款凭证or付款凭证）
    private String type;
    //是否完成资金的过度
    private Boolean receivable;
    //凭证是否有效
    private Boolean effective;
    //金额
    private Integer money;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getReceivable() {
        return receivable;
    }

    public void setReceivable(Boolean receivable) {
        this.receivable = receivable;
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
}
