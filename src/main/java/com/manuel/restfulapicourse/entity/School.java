package com.manuel.restfulapicourse.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "schools")
public class School {
    @Id
    private Integer id;
    @Column(name="school_name")
    private String schoolName;
    @Column(name = "school_location")
    private String location;
}
