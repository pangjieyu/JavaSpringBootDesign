package com.exercise.mysys.dao;

import com.exercise.mysys.domain.Customer;
import com.exercise.mysys.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @ProjectName 食品企业订货销售系统
 * @Author 朱向阳
 * @Date 2018/7/20 14:38
 * @Description: 客户类数据访问层
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //按主键查找
    Customer findCustomerById(Long id);
    //name模糊查询
    @Query("select t from Customer t where t.name like %?1%")
    List<Customer> myFind(String name);

}
