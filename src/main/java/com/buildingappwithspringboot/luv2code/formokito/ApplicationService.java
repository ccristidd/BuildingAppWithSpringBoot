package com.buildingappwithspringboot.luv2code.formokito;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ApplicationService {

    @Autowired
    ApplicationDao applicationDao;

    public double addGradeResultsForSingleClassService (List<Double> grades){
        return applicationDao.sumGradeResultsForSingleClass(grades);
    }
    public Double findGradePointAverageService(List<Double> grades){
        return applicationDao.findGradePointAverage(grades);
    }

    public Object checkNullService(Object obj){
        return applicationDao.checkNull(obj);
    }


}

