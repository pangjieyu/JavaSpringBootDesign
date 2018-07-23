package com.exercise.mysys.dao;

import com.exercise.mysys.domain.Customer;
import com.exercise.mysys.domain.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @ProjectName 食品企业订货销售系统
 * @Author 朱向阳
 * @Date 2018/7/20 14:40
 * @Description: 商品类的数据表示层
 */
public interface GoodRepository extends JpaRepository<Good, Long> {
    //按主键查找
    Good findGoodById(Long id);
    List<Good> findAll();
    //name模糊查询
    @Query("select t from Good t where t.name like %?1%")
    List<Good> myFind(String name);

    @Query("select t from Good t where t.name = ?1")
    List<Good> myFindJingque(String name);
}
