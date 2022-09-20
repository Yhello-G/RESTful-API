package com.manuel.restfulapicourse.controllers;

import com.manuel.restfulapicourse.dto.QueryName;
import com.manuel.restfulapicourse.dto.ResponseEntity;
import com.manuel.restfulapicourse.dto.TeacherDTO;
import com.manuel.restfulapicourse.dto.UpdateTeacherDTO;
import com.manuel.restfulapicourse.entity.Teacher;
import com.manuel.restfulapicourse.services.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TeacherController {
    @Autowired
    private TeacherServiceImpl teacherService;

    @Value("${application.name: RESTful App}")
    private String appName;

    @GetMapping("teachers")
    public List<ResponseEntity> getStudent(){
    return teacherService.getAllTeacher();
    }

    @PostMapping("/create")
    public Teacher insertTeacher(@Valid @RequestBody TeacherDTO teacher){

       return teacherService.insertTeacherToDb(teacher);
    }

    @PutMapping("/update")
    public ResponseEntity updateTeacher(@Valid @RequestBody UpdateTeacherDTO teacherDTO){

       return teacherService.updateTeacher(teacherDTO);

    }

    @DeleteMapping("teacher/delete")
    //@DeleteMapping("teacher/delete{id}") then @PathVariable("id")
    public String deleteTeacher(@RequestParam("id") Integer studentId){

       return teacherService.deleteTeacher(studentId);

    }
    // querying with WHERE clause with JPA
    @GetMapping("teacher/{firstname}")
    public List<Teacher> getTeachersWithFirstname(@PathVariable("firstname") String firstname){
       return teacherService.findTeacherByFirstname(firstname);
    }

    // querying with WHERE clause with JPA (multiple params)
    @GetMapping("teacher/{firstname}/{lastname}")
    public Teacher getTeacherFirstnameLastname(@PathVariable("firstname") String firstname,
                                               @PathVariable("lastname") String lastname){
      return   teacherService.findByFirstnameAndLastname(firstname, lastname);
    }

    // querying with WHERE Clause with OR
    @GetMapping("teachers/{firstname}/{lastname}")
    public List<ResponseEntity> getTeacherFirstnameOrLastname(@PathVariable("firstname") String firstname,
                                               @PathVariable("lastname") String lastname){
        return   teacherService.findByFirstnameORLastname(firstname, lastname);
    }

    // querying with IN operator in JPA
    @GetMapping("teachers/{something}")
    public List<ResponseEntity> getAllMatchingNames(@RequestBody QueryName queryNames){
        return teacherService.findByFirstnameIn(queryNames);
    }

    // querying with pagination aka limit and offset
    @GetMapping("teachers/paginate{pageNo}/{pageSize}")
    public List<Teacher> teachersWithPagination(@PathVariable("pageNo") Integer pageNo,
                                               @PathVariable("pageSize") Integer pageSize){
     return teacherService.paginatedTeachers(pageNo, pageSize);
    }

    // querying and sorting using spring JPA equivTo SortBy in SQL
    @GetMapping("teachers/{direction}")
    public List<Teacher> allTeacherSorted(@Valid @PathVariable("direction") String dir){
        return teacherService.findAllAndSort(dir);
    }

    // updating a particular teacher's record with a parameter from client
    @PutMapping("teacher/{id}/{email}")
    public String modifyRecord(@PathVariable("id") Integer teacherId,
                                @PathVariable("email") String email){
        Integer recordAffected = teacherService.updateTeacherEmail(teacherId, email);
        String message = recordAffected +" "+ "Updated";
        return message;
    }

    @Transactional
    @Modifying
    @DeleteMapping("teacher/{email}")
    public String deleteRecord(@PathVariable String email){
        return teacherService.deleteByFirstname(email) +" "+ "Recorded Deleted";
    }
}
