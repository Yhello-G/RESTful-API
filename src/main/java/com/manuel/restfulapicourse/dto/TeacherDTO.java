package com.manuel.restfulapicourse.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class TeacherDTO {

    @NotBlank(message = "first name is required")
    private String firstname;
    private String lastname;
    private String email;
    private String school;

}
