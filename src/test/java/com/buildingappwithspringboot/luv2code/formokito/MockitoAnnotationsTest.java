package com.buildingappwithspringboot.luv2code.formokito;

import com.buildingappwithspringboot.Application;
import com.buildingappwithspringboot.luv2code.component.models.CollegeStudent;
import com.buildingappwithspringboot.luv2code.component.models.StudentGrades;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = Application.class)
public class MockitoAnnotationsTest {

    ApplicationContext context;
    CollegeStudent collegeStudent1;
    StudentGrades studentGrades;


    @Autowired
    public MockitoAnnotationsTest(ApplicationContext context, CollegeStudent collegeStudent1
            , StudentGrades studentGrades) {
        this.context = context;
        this.collegeStudent1 = collegeStudent1;
        this.studentGrades = studentGrades;

    }

    //    @Mock ApplicationDao applicationDao;
//    @InjectMocks ApplicationService applicationService;
    @MockBean
    ApplicationDao applicationDao;
    @Autowired
    ApplicationService applicationService;

    @BeforeEach
    public void beforeEachTest() {
        collegeStudent1 = collegeStudent1.builder()
                .firstName("FirstName1")
                .lastName("LastName1")
                .emailAddress("email@address1")
                .studentGrades(studentGrades)
                .build();
    }

    @DisplayName("When and verify")
    @Test
    public void assertEqualsTestAndGrades() {
        //given. ii spune mock-ului ce sa returneze cand este apelat
        when(applicationDao.sumGradeResultsForSingleClass
                (collegeStudent1.getStudentGrades().getMathGradeResults())).thenReturn(100.00);

        //wehn then. aici aplam service-ul care apleaza applicationDao care este mockuit mai sus sa returneze 100
        assertEquals(100, applicationService.addGradeResultsForSingleClassService
                (collegeStudent1.getStudentGrades().getMathGradeResults()));
        verify(applicationDao).sumGradeResultsForSingleClass(any());
        verify(applicationDao, times(1)).sumGradeResultsForSingleClass
                (collegeStudent1.getStudentGrades().getMathGradeResults());
    }


    @DisplayName("find Gpa - grade point average")
    @Test
    public void testfindGradePointAverageService() {
        //given
        when(applicationDao.findGradePointAverage
                (collegeStudent1.getStudentGrades().getMathGradeResults())).thenReturn(100d);

        //when
        Double actual = applicationService.findGradePointAverageService
                (collegeStudent1.getStudentGrades().getMathGradeResults());
        //then
        assertEquals(100d, actual);
        verify(applicationDao).findGradePointAverage(any());
        verify(applicationDao, times(1)).findGradePointAverage(any());
    }

    @DisplayName("test check null method")
    @Test
    public void testCheckNotNullService() {
        Object obj = "abc";
        //given
        when(applicationDao.checkNull(obj)).thenReturn(obj);
        //when
        Object actual = applicationService.checkNullService(obj);
        //then
        assertNotNull(actual);
    }

    @DisplayName("test check null method")
    @Test
    public void testCheckNullService() {
        Object obj = "abc";
        //given
        when(applicationDao.checkNull(obj)).thenReturn(null);
        //when
        Object actual = applicationService.checkNullService(obj);
        //then
        assertNull(actual);
    }

    @DisplayName(" Throw Exception")
    @Test
    public void throwExceptionTest() {
        //given
        CollegeStudent collegeStudent2 = context.getBean("generateCollegeStudent", CollegeStudent.class);
        doThrow(new RuntimeException()).when(applicationDao).checkNull(collegeStudent2);

        //when
        Executable runnable = () -> applicationService.checkNullService(collegeStudent2);
        //then
        assertThrows(RuntimeException.class, runnable, "college student 2 is null");
         verify(applicationDao, times(1)).checkNull(collegeStudent2);
    }


    @DisplayName(" Throw Exception then dont't throw")
    @Test
    public void throwExceptionThenShowMessageTest() {
        //given
        CollegeStudent collegeStudent2 = context.getBean("generateCollegeStudent", CollegeStudent.class);
//         doThrow(new RuntimeException()).when(applicationDao.checkNull(collegeStudent2));
        when(applicationDao.checkNull(collegeStudent2))
                .thenThrow(new RuntimeException("college student 2 is null"))
                .thenReturn("mesajul de la al doilea apel al functiei");
        //when
        Executable runnable = () -> applicationService.checkNullService(collegeStudent2);
        //then
        assertThrows(RuntimeException.class, runnable, "college student 2 is null");
        assertEquals("mesajul de la al doilea apel al functiei", applicationDao.checkNull(collegeStudent2));

        verify(applicationDao, times(2)).checkNull(collegeStudent2);
    }
}
