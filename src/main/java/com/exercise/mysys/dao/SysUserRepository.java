package com.exercise.mysys.dao;

import com.exercise.mysys.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository<SysUser,Long> {
    //通过username找user
    SysUser findSysUserByUsername(String username);
}
