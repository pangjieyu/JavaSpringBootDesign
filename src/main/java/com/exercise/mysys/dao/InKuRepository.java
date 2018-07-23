package com.exercise.mysys.dao;

import com.exercise.mysys.domain.InKu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ProjectName 食品企业订货销售系统
 * @Author 朱向阳
 * @Date 2018/7/20 16:15
 * @Description: 入库单类的数据访问层
 */
public interface InKuRepository extends JpaRepository<InKu, Long> {
    InKu findInKuById(Long id);
}

