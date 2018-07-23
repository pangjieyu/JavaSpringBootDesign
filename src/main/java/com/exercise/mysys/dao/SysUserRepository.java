package com.exercise.mysys.dao;

import com.exercise.mysys.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @ProjectName 食品企业订货销售系统
 * @Author 朱向阳
 * @Date 2018/7/20 14:38
 * @Description: 用户类的数据访问层
 */
public interface SysUserRepository extends JpaRepository<SysUser,Long> {
    //通过username找user
    SysUser findSysUserByUsername(String username);
    SysUser findSysUserById(Long id);
    List<SysUser> findAllByRole(String role);
    @Query("select t from SysUser t where t.role = ?1 and t.name like %?2%")
    List<SysUser> myFind(String bumen, String name);

}
