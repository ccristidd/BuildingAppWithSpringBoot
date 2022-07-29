package com.buildingappwithspringboot.luv2code.component.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CollegeStudent implements Student{

    private int id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private StudentGrades studentGrades;


    @Override
    public String studentInformation() {
        return getFullName() + getEmailAddress();
    }

    @Override
    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    private String getFirstNameAndId(){
        return firstName + " " + id;
    }


}
