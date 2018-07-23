package com.exercise.mysys.dao;

import com.exercise.mysys.domain.Store;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ProjectName 食品企业订货销售系统
 * @Author 朱向阳
 * @Date 2018/7/20 16:01
 * @Description: 库存类的数据访问层
 */
public interface StoreRepository extends JpaRepository<Store, Long> {
    @Override
    <S extends Store> List<S> findAll(Example<S> example);
    Store findStoreById(Long id);
}
