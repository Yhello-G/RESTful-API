package com.manuel.restfulapicourse.services.impl;

import com.manuel.restfulapicourse.dto.QueryName;
import com.manuel.restfulapicourse.dto.TeacherDTO;
import com.manuel.restfulapicourse.dto.UpdateTeacherDTO;
import com.manuel.restfulapicourse.entity.Address;
import com.manuel.restfulapicourse.entity.Teacher;
import com.manuel.restfulapicourse.repository.AddressDAO;
import com.manuel.restfulapicourse.repository.TeacherDAO;
import com.manuel.restfulapicourse.services.TeacherService;
import com.manuel.restfulapicourse.dto.TeacherEntityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private  TeacherDAO teacherDAO;
    @Autowired
    private AddressDAO addressDAO;

    private TeacherEntityResponse teacherEntityResponse;

    @Override
    public List <TeacherEntityResponse> getAllTeacher() {
      List<Teacher> teachers = teacherDAO.findAll();
      List<TeacherEntityResponse> responseEntities = new ArrayList<>();
      teachers.stream().forEach(teacher -> {
          TeacherEntityResponse response = new TeacherEntityResponse(teacher);
          responseEntities.add(response);
      });
      return responseEntities;
    }

    @Override
    public Teacher insertTeacherToDb(TeacherDTO teacherDTO) {
        Teacher aTeacher = new Teacher(teacherDTO);
        Address address = new Address(teacherDTO);
        addressDAO.save(address);
        aTeacher.setAddress(address);
        Teacher savedTeacher = teacherDAO.save(aTeacher);
        return savedTeacher;
    }

    @Override
    public TeacherEntityResponse updateTeacher(UpdateTeacherDTO teacherDTO) {
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
        return new TeacherEntityResponse(aTeacher);

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
    public List<TeacherEntityResponse> findByFirstnameORLastname(String firstname, String lastname) {
        List<Teacher> teachers = teacherDAO.findByFirstnameOrLastname(firstname, lastname);
        List<TeacherEntityResponse> teacherEntityResponseList = new ArrayList<>();

        teachers.stream().forEach(teacher -> {
            teacherEntityResponseList.add(new TeacherEntityResponse(teacher));
        });
        return teacherEntityResponseList;
    }

    @Override
    public List<TeacherEntityResponse> findByFirstnameIn(QueryName queryNames) {
        List<Teacher> teachers = teacherDAO.findByFirstnameIn(queryNames.getFirstnames());
        List<TeacherEntityResponse> teacherEntityResponseList = new ArrayList<>();

        teachers.stream().forEach(teacher -> {
            teacherEntityResponseList.add(new TeacherEntityResponse(teacher));
        });
        return teacherEntityResponseList;
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
