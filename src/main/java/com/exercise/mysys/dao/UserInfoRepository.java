package com.exercise.mysys.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exercise.mysys.domain.UserInfo;
import com.exercise.mysys.domain.ViewInfo;
import com.exercise.mysys.domain.Address;
import com.exercise.mysys.domain.Salary;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    @Query(value = "SELECT new com.exercise.mysys.domain.ViewInfo(u, a,b) FROM UserInfo u, Address a,Salary b WHERE u.addressId = a.addressId and b.userId = u.userId")
    public List<ViewInfo> findViewInfo();
}