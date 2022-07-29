package com.buildingappwithspringboot.testing.testutils;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS) if beforeAll and afterAll are not static
//@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
class TestUtilsTest {

    TestUtils testUtils;

    @BeforeAll
    static void beforeAllTests() {
        System.out.println("executed before all tests");
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("executed after all tests");
    }

    @BeforeEach
    void setupBeforeEachTest() {
        System.out.println("new calculator is created");
        testUtils = new TestUtils();
    }

    @AfterEach
    void tearDownAfterEachTest() {
        System.out.println("Nothing to do after each test for now");
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_11)

        //@DisplayName("test add method" )
    void testAddingTwoIntegers() {
//        Calculator calculator = new Calculator();
        int expect = 8;
        int actual = testUtils.add(4, 4);
        Assertions.assertEquals(expect, actual);
        assertNotEquals(10l, actual, "should not be equal to 10l ");
    }

    @Test
        //@DisplayName("test substract method")
    void testSubstractingTwoIntegers() {
//        Calculator calculator = new Calculator();
        int expect = 6;
        int notexpect = 8;
        int actual = testUtils.substract(13, 7);
        assertEquals(expect, actual);
        assertNotEquals(notexpect, actual, "13-7 nu fac 8");
        assertEquals(9, testUtils.substract(19, 10));
        assertNotEquals(9, testUtils.substract(10, 2), "substract difference");
    }

    @Test
        //@DisplayName("test null or string method")
    void testTheNullFuntcion() {
        assertNull(null, testUtils.nullOrNotNull("null"));
        assertNotNull("string", testUtils.nullOrNotNull("string"));
    }

    @Test
        //@DisplayName("test bigger number checker")
    void testBiggerNumberChecker() {
        assertTrue(testUtils.biggerIntegerChecker(5, 4));
        assertFalse(testUtils.biggerIntegerChecker(5, 8));
    }

    @Test
        //@DisplayName("test array of first 3 alphabet letters")
    void testArrayWithFirstThreeAlphabetLetters() {
        String[] letters = {"A", "B", "C"};
        List<String> listOfLetters = List.of("A", "B", "C");
        assertArrayEquals(letters, testUtils.getFirstThreeLettersOfAlphabet());
        assertIterableEquals(listOfLetters, testUtils.getLetterList());
        assertLinesMatch(listOfLetters, testUtils.getLetterList());
    }

    @Test
    @Order(0)
        //@DisplayName("test throw exception")
    void testExceptionThrow() throws Exception {
        assertThrows(Exception.class, () -> {
                    testUtils.exceptionIfNumberIsLessThan0(-1);
                }
                , "number should be less thatn 0");
        assertDoesNotThrow(() -> testUtils.exceptionIfNumberIsLessThan0(1),
                "number should not be less than 0");
    }

    @Test
    @Order(-1)
        //@DisplayName("check if it executes in a period of time")
    void testIfExecutedInTime() throws InterruptedException {
        assertTimeoutPreemptively(Duration.ofSeconds(4), () -> testUtils.checkTimeout());
    }

    @Test
    @EnabledIfSystemProperty(named="NameOfProperty", matches= "valueOfProperty")
    void testSystemProperty(){
        //testul nu face nimic dar se ruleaza doar daca sunt setate system property
    }
    @Test
    @EnabledIfEnvironmentVariable(named="NameOfVariable", matches= "valueOfVariable")
    void testEnvironmentVariable(){
        //testul nu face nimic dar se ruleaza doar daca sunt setate environment variable
    }



}