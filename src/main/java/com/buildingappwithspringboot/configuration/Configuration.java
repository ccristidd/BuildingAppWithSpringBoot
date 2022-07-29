package com.buildingappwithspringboot.configuration;

import com.buildingappwithspringboot.luv2code.component.models.CollegeStudent;
import com.buildingappwithspringboot.luv2code.component.models.StudentGrades;
import com.buildingappwithspringboot.luv2code.formokito.ApplicationDao;
import com.buildingappwithspringboot.luv2code.formokito.ApplicationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages = "com.buildingappwithspringboot")
public class Configuration {

    @Bean(name = "generateCollegeStudent")
    @Scope(value = "prototype")  //the bean is created every time a new request is generated for it
    CollegeStudent getCollegeStudent() {
        return new CollegeStudent();
    }

    @Bean(name = "generateStudentGrades")
    @Scope(value = "prototype") //the bean is created every time a new request is generated for it
    StudentGrades getStudentGrades() {
        return new StudentGrades();
    }

    @Bean(name = "applicationDao")
    ApplicationDao getApplicationDao(){
        return new ApplicationDao();
    }

    @Bean(name = "applicationService")
    ApplicationService getApplicationService(){
        return new ApplicationService();
    }

}
