package com.buildingappwithspringboot.luv2code.component.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentGrades {
    List<Double> mathGradeResults;

    public double addGradeResultsForSingleClass(List<Double> grades) {
        Double result = 0d;
        for (Double grade : grades) {
            result += grade;
        }
        return result;
    }

    public Double findGradePointAverage(List<Double> grades) {
        Double average = addGradeResultsForSingleClass(grades) / grades.size();
        //double does not have RoundingMode so we convert to BigDecimal then back
        BigDecimal resultRound = BigDecimal.valueOf(average).setScale(2, RoundingMode.UP);
        return resultRound.doubleValue();
    }

    public boolean isGradeGrater(double grade1, double grade2) {
        return grade1 > grade2;
    }

    public Object checkNull(Object obj){
        if(obj != null){
            return obj;
        }
        return null;
    }




}
