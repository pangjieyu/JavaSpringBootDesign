package com.exercise.mysys.dao;

import com.exercise.mysys.domain.ManufacturePlan;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ProjectName 食品企业订货销售系统
 * @Author 朱向阳
 * @Date 2018/7/20 15:18
 * @Description: 生产计划的数据访问层
 */
public interface ManufacturePlanRepository extends JpaRepository<ManufacturePlan, Long> {
    @Override
    <S extends ManufacturePlan> List<S> findAll(Example<S> example);
    ManufacturePlan findManufacturePlanById(Long id);
}
