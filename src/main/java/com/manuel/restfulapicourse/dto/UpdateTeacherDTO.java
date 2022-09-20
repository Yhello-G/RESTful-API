package com.manuel.restfulapicourse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTeacherDTO implements Serializable {
    @NonNull
    int  id;
    private String firstname;
    private String lastname;
    private String email;
    private String school;
}
