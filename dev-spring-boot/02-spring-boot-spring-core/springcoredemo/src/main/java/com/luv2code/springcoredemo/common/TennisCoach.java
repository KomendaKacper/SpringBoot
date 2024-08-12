package com.luv2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component

//Żeby tworzyło nowe obiekty, sprawdź se
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TennisCoach implements Coach{

    public TennisCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    //define our init method
//    @PostConstruct
//    public void doMyStartupStuff(){
//        System.out.println("In doMyStartupStuff: " + getClass().getSimpleName());
//    }
//
//    //define our destroy method
//    @PreDestroy
//    public void doMyCleanupStuff(){
//        System.out.println("In doMyCleanupStuff: " + getClass().getSimpleName());
//    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}


