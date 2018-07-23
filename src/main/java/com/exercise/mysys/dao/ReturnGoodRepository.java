package com.exercise.mysys.dao;

import com.exercise.mysys.domain.ReturnGood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ProjectName 食品企业订货销售系统
 * @Author 朱向阳
 * @Date 2018/7/20 15:40
 * @Description: 退货单类的数据访问层
 */
public interface ReturnGoodRepository extends JpaRepository<ReturnGood, Long> {
    List<ReturnGood> findAll();
    ReturnGood findReturnGoodById(Long id);
}
