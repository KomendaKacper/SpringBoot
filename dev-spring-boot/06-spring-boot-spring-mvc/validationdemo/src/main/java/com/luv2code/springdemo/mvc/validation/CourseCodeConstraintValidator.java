package com.luv2code.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefx;

    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefx = theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {


        boolean result;
        if (theCode != null){
            result = theCode.startsWith(coursePrefx);
        }
        else{
            result=true;
        }

        return result;
    }
}
