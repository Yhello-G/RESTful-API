package com.manuel.restfulapicourse.services.impl;

import com.manuel.restfulapicourse.dto.QueryName;
import com.manuel.restfulapicourse.dto.TeacherDTO;
import com.manuel.restfulapicourse.dto.UpdateTeacherDTO;
import com.manuel.restfulapicourse.entity.Teacher;
import com.manuel.restfulapicourse.repository.TeacherDAO;
import com.manuel.restfulapicourse.services.TeacherService;
import com.manuel.restfulapicourse.dto.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private  TeacherDAO teacherDAO;

    private ResponseEntity responseEntity;

    @Override
    public List <ResponseEntity> getAllTeacher() {
      List<Teacher> teachers = teacherDAO.findAll();
      List<ResponseEntity> responseEntities = new ArrayList<>();
      teachers.stream().forEach(teacher -> {
          ResponseEntity response = new ResponseEntity(teacher);
          responseEntities.add(response);
      });
      return responseEntities;
    }

    @Override
    public Teacher insertTeacherToDb(TeacherDTO teacher) {
        Teacher aTeacher = new Teacher(teacher);
        return teacherDAO.save(aTeacher);

    }

    @Override
    public ResponseEntity updateTeacher(UpdateTeacherDTO teacherDTO) {
        int id = teacherDTO.getId();

        Teacher teacher = new Teacher();
         Optional<Teacher> dbTeacher = teacherDAO.findById(id);
         if (dbTeacher.isPresent()){
                if (teacherDTO.getFirstname() != null && !teacherDTO.getFirstname()
                 .isBlank()){
                 String   name = teacherDTO.getFirstname();
            teacher =  dbTeacher.get();
            teacher.setFirstname(name);
         }}
         Teacher aTeacher = teacherDAO.save(teacher);
        return new ResponseEntity(aTeacher);

    }

    @Override
    public String deleteTeacher(Integer studentId) {
            teacherDAO.deleteById(studentId);
        return "Successfully deleted";

    }

    @Override

    public List<Teacher> findTeacherByFirstname(String firstname) {
       List<Teacher> teachers = teacherDAO.findByFirstname(firstname);
        return teachers;
    }

    @Override
    public Teacher findByFirstnameAndLastname(String firstname, String lastname) {
       return teacherDAO.findByFirstnameAndLastname(firstname, lastname);
        //return null;
    }

    @Override
    public List<ResponseEntity> findByFirstnameORLastname(String firstname, String lastname) {
        List<Teacher> teachers = teacherDAO.findByFirstnameOrLastname(firstname, lastname);
        List<ResponseEntity> responseEntityList = new ArrayList<>();

        teachers.stream().forEach(teacher -> {
            responseEntityList.add(new ResponseEntity(teacher));
        });
        return responseEntityList;
    }

    @Override
    public List<ResponseEntity> findByFirstnameIn(QueryName queryNames) {
        List<Teacher> teachers = teacherDAO.findByFirstnameIn(queryNames.getFirstnames());
        List<ResponseEntity> responseEntityList = new ArrayList<>();

        teachers.stream().forEach(teacher -> {
            responseEntityList.add(new ResponseEntity(teacher));
        });
        return responseEntityList;
    }

    @Override
    public List<Teacher> paginatedTeachers(Integer pageNo, Integer pageSize) {
        Pageable page = PageRequest.of(pageNo - 1, pageSize);
        return teacherDAO.findAll(page).getContent();

    }

    @Override
    public List<Teacher> findAllAndSort(String dir) {
        Sort sort;
        if ("asc".equalsIgnoreCase(dir)) {
             sort = Sort.by(Sort.Direction.ASC, "firstname");
        }
        sort = Sort.by(Sort.Direction.DESC, "firstname");

       return teacherDAO.findAll(sort);
    }

    @Override
    public Integer updateTeacherEmail(Integer teacherId, String email) {
        return teacherDAO.upadteRecordOf(teacherId, email);
    }

    @Override
    public Integer deleteByFirstname(String email) {
        return teacherDAO.deleteTeacher(email);

    }


}
