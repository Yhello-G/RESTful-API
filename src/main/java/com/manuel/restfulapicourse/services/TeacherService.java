package com.manuel.restfulapicourse.services;

import com.manuel.restfulapicourse.dto.QueryName;
import com.manuel.restfulapicourse.dto.TeacherEntityResponse;
import com.manuel.restfulapicourse.dto.TeacherDTO;
import com.manuel.restfulapicourse.dto.UpdateTeacherDTO;
import com.manuel.restfulapicourse.entity.Teacher;

import java.util.List;

public interface TeacherService {

    List<TeacherEntityResponse> getAllTeacher();

    Teacher insertTeacherToDb(TeacherDTO teacher);

    TeacherEntityResponse updateTeacher(UpdateTeacherDTO teacher);

    String deleteTeacher(Integer studentId);

    List<Teacher> findTeacherByFirstname(String firstname);

    Teacher findByFirstnameAndLastname(String firstname, String lastname);

    List<TeacherEntityResponse> findByFirstnameORLastname(String firstname, String lastname);

    List<TeacherEntityResponse> findByFirstnameIn(QueryName queryNames);

    List<Teacher> paginatedTeachers(Integer pageNo, Integer pageSize);

    List<Teacher> findAllAndSort(String dir);

    Integer updateTeacherEmail(Integer teacherId, String email);

    Integer deleteByFirstname(String email);
}
