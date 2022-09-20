package com.manuel.restfulapicourse.entity;

import com.manuel.restfulapicourse.dto.TeacherDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "teachers")
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name="first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "teacher_email")
    private String email;
    @Column(name = "school_taught")
    private String school;

    public Teacher(TeacherDTO teacherDTO){
        this.firstname = teacherDTO.getFirstname();
        this.lastname = teacherDTO.getLastname();
        this.email = teacherDTO.getEmail();
        this.school = teacherDTO.getSchool();
    }
}
