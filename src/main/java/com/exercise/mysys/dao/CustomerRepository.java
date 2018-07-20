package com.exercise.mysys.dao;

import com.exercise.mysys.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @ProjectName 食品企业订货销售系统
 * @Author 朱向阳
 * @Date 2018/7/20 14:38
 * @Description: 客户类数据访问层
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
