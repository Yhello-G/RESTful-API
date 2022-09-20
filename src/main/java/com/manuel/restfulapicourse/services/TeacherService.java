package com.manuel.restfulapicourse.services;

import com.manuel.restfulapicourse.dto.QueryName;
import com.manuel.restfulapicourse.dto.ResponseEntity;
import com.manuel.restfulapicourse.dto.TeacherDTO;
import com.manuel.restfulapicourse.dto.UpdateTeacherDTO;
import com.manuel.restfulapicourse.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TeacherService {

    List<ResponseEntity> getAllTeacher();

    Teacher insertTeacherToDb(TeacherDTO teacher);

    ResponseEntity updateTeacher(UpdateTeacherDTO teacher);

    String deleteTeacher(Integer studentId);

    List<Teacher> findTeacherByFirstname(String firstname);

    Teacher findByFirstnameAndLastname(String firstname, String lastname);

    List<ResponseEntity> findByFirstnameORLastname(String firstname, String lastname);

    List<ResponseEntity> findByFirstnameIn(QueryName queryNames);

    List<Teacher> paginatedTeachers(Integer pageNo, Integer pageSize);

    List<Teacher> findAllAndSort(String dir);
}
