package com.manuel.restfulapicourse.repository;

import com.manuel.restfulapicourse.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherDAO extends JpaRepository<Teacher, Integer> {
    List<Teacher> findByFirstname(String firstname);
    Teacher findByFirstnameAndLastname(String firstname, String lastname);

    List<Teacher> findByFirstnameOrLastname(String firstname, String lastname);
    List<Teacher> findByFirstnameIn(List<String> firstnames);
}
