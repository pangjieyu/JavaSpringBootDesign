package com.exercise.mysys.dao;

import com.exercise.mysys.domain.Pick;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ProjectName 食品企业订货销售系统
 * @Author 朱向阳
 * @Date 2018/7/20 15:57
 * @Description: 提货单类的数据表示层
 */
public interface PickRepository extends JpaRepository<Pick,Long>{
    Pick findPickById(Long id);
}
