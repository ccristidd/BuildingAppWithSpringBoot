package com.buildingappwithspringboot.luv2code.formokito;

import com.buildingappwithspringboot.Application;
import com.buildingappwithspringboot.luv2code.component.models.CollegeStudent;
import com.buildingappwithspringboot.luv2code.component.models.StudentGrades;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Application.class)
public class ReflectionTestUtilsTest {

    StudentGrades studentGrades;
    CollegeStudent collegeStudent1;

    @Autowired
    public ReflectionTestUtilsTest(CollegeStudent collegeStudent1, StudentGrades studentGrades) {
        this.collegeStudent1 = collegeStudent1;
        this.studentGrades = studentGrades;
    }

    @BeforeEach
    public void runBeforeEachTest() {
        collegeStudent1 = collegeStudent1.builder()
                .firstName("George")
                .lastName("Stefan")
                .emailAddress("george.stefan@ymail.com")
                .studentGrades(studentGrades)
                .build();
        ReflectionTestUtils.setField(collegeStudent1,"studentGrades"
                ,new StudentGrades(List.of(10d, 50d, 90d)));
        ReflectionTestUtils.setField(collegeStudent1,"id",1);
    }

    @DisplayName("test the privet fields set with ReflectionTestUtils")
    @Test
    public void testFieldValuesSetByReflection(){
        assertEquals(1,ReflectionTestUtils.getField
                (collegeStudent1, "id"));
        assertEquals("George 1", ReflectionTestUtils.invokeMethod
                (collegeStudent1,"getFirstNameAndId"));
    }



}
