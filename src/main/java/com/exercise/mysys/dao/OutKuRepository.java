package com.exercise.mysys.dao;

import com.exercise.mysys.domain.OutKu;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ProjectName 食品企业订货销售系统
 * @Author 朱向阳
 * @Date 2018/7/20 16:09
 * @Description: 出库单类的数据表示层
 */
public interface OutKuRepository extends JpaRepository<OutKu,Long> {
}
