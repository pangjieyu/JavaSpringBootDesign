package com.exercise.mysys.dao;

import com.exercise.mysys.domain.OrderGood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ProjectName 食品企业订货销售系统
 * @Author 朱向阳
 * @Date 2018/7/20 15:03
 * @Description: 订货单类的数据表示层
 */
public interface OrderGoodRepository extends JpaRepository<OrderGood, Long> {
<<<<<<< Updated upstream
=======
    List<OrderGood> findAll();
    OrderGood findById(long id);
    void delete(OrderGood order);

    default OrderGood save(OrderGood order) {
        return null;
    }
>>>>>>> Stashed changes
}
