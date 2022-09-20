package com.manuel.restfulapicourse.entity;

import com.manuel.restfulapicourse.dto.TeacherDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "address")
@Builder
@AllArgsConstructor

public class Address {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(name = "street_name")
    private String street;
    @Column(name="state_name")
    private String state;

    public Address(TeacherDTO teacherDTO){
        this.street = teacherDTO.getStreet();
        this.state = teacherDTO.getState();
    }

}
