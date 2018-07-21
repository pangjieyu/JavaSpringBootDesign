package com.exercise.mysys.service;

import com.exercise.mysys.dao.SysUserRepository;
import com.exercise.mysys.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * @ProjectName 食品企业订货销售系统
 * @Author 朱向阳
 * @Date 2018/7/20 14:38
 * @Description: 用户类所提供的注释
 */
public class SysUserDetailsService implements UserDetailsService {
    @Autowired
    SysUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser user = userRepository.findSysUserByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return user;
    }

}
