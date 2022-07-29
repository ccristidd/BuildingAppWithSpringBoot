package com.buildingappwithspringboot.luv2code.formokito;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ApplicationDao {

    public double sumGradeResultsForSingleClass(List<Double> grades) {
        Double result = 0d;
        for (Double grade : grades) {
            result += grade;
        }
        return result;
    }

    public Double findGradePointAverage(List<Double> grades) {
        Double average = sumGradeResultsForSingleClass(grades) / grades.size();
        //double does not have RoundingMode so we convert to BigDecimal then back
        BigDecimal resultRound = BigDecimal.valueOf(average).setScale(2, RoundingMode.UP);
        return resultRound.doubleValue();
    }

    public Object checkNull(Object obj){
        if(obj != null){
            return obj;
        }
        return null;
    }
}
