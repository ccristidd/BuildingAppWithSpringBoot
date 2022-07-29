package com.buildingappwithspringboot.testing.testutils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestUtils {
    private int a;
    private int b;

    public int add(int a, int b) {
        return a + b;
    }

    public int substract(int a, int b) {
        return a - b;
    }

    public String nullOrNotNull(String a) {
        if (a.equalsIgnoreCase("null")) {
            return null;
        } else return a;
    }

    public boolean biggerIntegerChecker(int a, int b) {
        return a > b;
    }

    public String[] getFirstThreeLettersOfAlphabet() {
        String[] array = {"A", "B", "C"};
        return array;
    }
    public List<String> getLetterList() {
        List<String> stringList =List.of("A", "B", "C");
        return stringList;
    }

    public void exceptionIfNumberIsLessThan0(int a) throws Exception {
        if(a<0){
            throw new Exception("Number is less than 0");
        }
    }

    public void checkTimeout() throws InterruptedException {
        System.out.println("before go to sleep");
        Thread.sleep(3000);
        System.out.println("sleep over");

    }

//    public static void main(String[] args) {
//        Calculator c =  new Calculator();
//
//        System.out.println(c.substract(3,5));
//    }
}
