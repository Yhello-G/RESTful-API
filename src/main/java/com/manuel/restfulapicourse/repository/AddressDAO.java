package com.manuel.restfulapicourse.repository;

import com.manuel.restfulapicourse.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDAO extends JpaRepository<Address, Integer> {

}
