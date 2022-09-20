package com.manuel.restfulapicourse.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.manuel.restfulapicourse.entity.Teacher;
import lombok.*;

@AllArgsConstructor
@Data
@Builder
public class ResponseEntity {

    @JsonIgnore  //to ignore a field i dont want to populate as response
    private String id;
    //@JsonProperty("fname") // to modify the field key  as json response
    private String firstname;
    private String lastname;
    private String email;


    public ResponseEntity(Teacher teacher){
        this.firstname = teacher.getFirstname();
        this.lastname  = teacher.getLastname();
        this.email = teacher.getEmail();
    }

}
