package com.buildingappwithspringboot;

import com.buildingappwithspringboot.luv2code.component.models.CollegeStudent;
import com.buildingappwithspringboot.luv2code.component.models.StudentGrades;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner (ApplicationContext context){
//        return args -> {
//            System.out.println("The beans used by this applications are: ");
//            String[] beanNames = context.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for(String bean :beanNames){
//                System.out.println(bean);
//            }
//        };
//    }



}
