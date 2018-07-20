package com.exercise.mysys.dao;

import com.exercise.mysys.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @ProjectName 食品企业订货销售系统
 * @Author 朱向阳
 * @Date 2018/7/20 14:38
 * @Description: 用户类的数据访问层
 */
public interface SysUserRepository extends JpaRepository<SysUser,Long> {
    //通过username找user
    SysUser findSysUserByUsername(String username);
}
