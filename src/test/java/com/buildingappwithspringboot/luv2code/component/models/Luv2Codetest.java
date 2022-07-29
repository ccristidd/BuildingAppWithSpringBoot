package com.buildingappwithspringboot.luv2code.component.models;

import com.buildingappwithspringboot.Application;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


//the classes property is added in case the main package of the app is different from the main package of the test
@SpringBootTest(classes = Application.class)

public class Luv2Codetest {

    private CollegeStudent collegeStudent;
    private StudentGrades studentGrades;
    @Autowired
    private ApplicationContext context;


    @Autowired
    public Luv2Codetest(CollegeStudent collegeStudent, StudentGrades studentGrades, CollegeStudent collegeStudent2) {
        this.collegeStudent = collegeStudent;
        this.studentGrades = studentGrades;
    }

    private int counter = 0;

    @Value("${info.app.name}")
    private String appInfo;

    @Value("${info.app.description}")
    private String appDescription;

    @Value("${info.app.version}")
    private String appVersion;

    @Value("${info.school.name}")
    private String schoolName;


    @BeforeEach
    public void beforeEachtest() {
        counter = counter + 1;
        System.out.println("app info: " + appInfo + ", app description: " + appDescription
                + ", app version: " + appVersion + ", school name: " + schoolName + ", counter: " + counter);

        List<Double> gradesList = List.of(4d, 5d, 6.9, 11d);
        studentGrades.setMathGradeResults(gradesList);
        collegeStudent = collegeStudent.builder()
                .firstName("George")
                .lastName("Stefan")
                .emailAddress("george.stefan@ymail.com")
                .studentGrades(studentGrades)
                .build();
    }

    @Test
    void basicTest() {
        //do nothing
    }

    @DisplayName("add grade results for math")
    @Test
    public void testAddGradeResults() {
        assertEquals(26.9, studentGrades.addGradeResultsForSingleClass
                (collegeStudent.getStudentGrades().getMathGradeResults()));
        assertNotEquals(0, studentGrades.addGradeResultsForSingleClass
                (collegeStudent.getStudentGrades().getMathGradeResults()));
    }

    @DisplayName("test is grater than method")
    @Test
    public void testIsGraterThan() {
        Double firstStudentGrade = collegeStudent.getStudentGrades().getMathGradeResults().get(0);
        Double secondStudentGrade = collegeStudent.getStudentGrades().getMathGradeResults().get(1);
        Double thirdStudentGrade = collegeStudent.getStudentGrades().getMathGradeResults().get(3);
        assertTrue(studentGrades.isGradeGrater(10, secondStudentGrade));
        assertFalse(studentGrades.isGradeGrater(10, thirdStudentGrade));
        assertTrue(studentGrades.isGradeGrater(10, secondStudentGrade));
    }

    @DisplayName("check null values")
    @Test
    public void testNullValues() {
        assertNotNull(studentGrades.checkNull
                (collegeStudent.getStudentGrades().getMathGradeResults().get(3)));
    }

    @DisplayName("create student without crade in it")
    @Test
    void testCreateNewStudentWithoutGrades() {
        CollegeStudent collegeStudent2 = context.getBean("generateCollegeStudent", CollegeStudent.class);
        collegeStudent2 = collegeStudent2.builder()
                .firstName("student2FirstName")
                .lastName("student2LastName")
                .emailAddress("student2@ymail.com")
                .build();
        assertNull(collegeStudent2.getStudentGrades());
        assertNotNull(collegeStudent2.getEmailAddress());
        assertNotSame(collegeStudent2, collegeStudent);
    }

    @DisplayName("find grade point average")
    @Test
    public void findGradePointAverage() {
        int numberOfGrades = collegeStudent.getStudentGrades().getMathGradeResults().size();
        Double gradeSum = studentGrades.addGradeResultsForSingleClass
                (collegeStudent.getStudentGrades().getMathGradeResults());
        Double average = gradeSum / numberOfGrades;
        Double avg = new BigDecimal(average).setScale(2, RoundingMode.UP).doubleValue();

        assertAll("Testing all assert equals",
                () -> assertEquals(avg, studentGrades.findGradePointAverage
                        (collegeStudent.getStudentGrades().getMathGradeResults())),
                () -> assertEquals(numberOfGrades, studentGrades.getMathGradeResults().size()),
                () -> assertEquals(gradeSum, studentGrades.addGradeResultsForSingleClass
                        (studentGrades.getMathGradeResults())));
    }


}
