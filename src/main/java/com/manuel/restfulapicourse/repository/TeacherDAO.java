package com.manuel.restfulapicourse.repository;

import com.manuel.restfulapicourse.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TeacherDAO extends JpaRepository<Teacher, Integer> {
    List<Teacher> findByFirstname(String firstname);
    Teacher findByFirstnameAndLastname(String firstname, String lastname);

    List<Teacher> findByFirstnameOrLastname(String firstname, String lastname);
    List<Teacher> findByFirstnameIn(List<String> firstnames);

    //JPQL customise query
    @Query("from teachers where firstname = :firstname and lastname = :lastname")
    Teacher retrieveWithFirstAndLast(@Param("firstname") String firstname, @Param("lastname") String lastname);
    @Modifying
    @Transactional
    @Query("UPDATE teachers set email = :emailAddr where id = :teacherId")
    Integer upadteRecordOf(Integer teacherId, String emailAddr);

    @Query("delete from teachers where email = :email")
    Integer deleteTeacher(String email);
}
