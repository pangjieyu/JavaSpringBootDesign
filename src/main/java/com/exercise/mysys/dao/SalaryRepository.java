package com.exercise.mysys.dao;

import com.exercise.mysys.domain.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

import com.exercise.mysys.domain.Address;

public interface SalaryRepository extends JpaRepository<Salary, Long> {

}
