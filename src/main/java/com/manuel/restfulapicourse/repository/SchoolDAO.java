package com.manuel.restfulapicourse.repository;

import com.manuel.restfulapicourse.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolDAO extends JpaRepository<School, Integer> {


}
