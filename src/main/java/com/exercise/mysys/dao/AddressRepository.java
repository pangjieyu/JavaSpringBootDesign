package com.exercise.mysys.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercise.mysys.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
