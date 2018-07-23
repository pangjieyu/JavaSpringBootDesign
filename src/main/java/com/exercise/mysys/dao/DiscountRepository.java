package com.exercise.mysys.dao;

import com.exercise.mysys.domain.Discount;
import com.exercise.mysys.domain.Good;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ProjectName 食品企业订货销售系统
 * @Author 朱向阳
 * @Date 2018/7/20 16:18
 * @Description: 优惠信息单类的数据访问层
 */
public interface DiscountRepository extends JpaRepository<Discount, Long> {
    Discount findDiscountById(Long id);
}
