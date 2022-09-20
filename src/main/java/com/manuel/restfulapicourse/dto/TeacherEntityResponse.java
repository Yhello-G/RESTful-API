package com.manuel.restfulapicourse.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.manuel.restfulapicourse.entity.Address;
import com.manuel.restfulapicourse.entity.Teacher;
import lombok.*;

@AllArgsConstructor
@Data
@Builder
public class TeacherEntityResponse {

    @JsonIgnore  //to ignore a field i dont want to populate as response
    private String id;
    //@JsonProperty("fname") // to modify the field key  as json response
    private String firstname;
    private String lastname;
    private String email;
    private String street;
    private String state;



    public TeacherEntityResponse(Teacher teacher){
        this.firstname = teacher.getFirstname();
        this.lastname  = teacher.getLastname();
        this.email = teacher.getEmail();
        this.street = teacher.getAddress().getStreet();
        this.state = teacher.getAddress().getState();
    }

}
