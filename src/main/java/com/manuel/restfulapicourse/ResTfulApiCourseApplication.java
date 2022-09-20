package com.manuel.restfulapicourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan({"com.manuel.restfulapicourse.entity"})
@EnableJpaRepositories({"com.manuel.restfulapicourse.repository"})
public class ResTfulApiCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResTfulApiCourseApplication.class, args);
    }

}
