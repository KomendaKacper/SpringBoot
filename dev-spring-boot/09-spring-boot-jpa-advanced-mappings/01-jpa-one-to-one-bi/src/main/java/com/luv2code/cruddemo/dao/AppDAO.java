package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

public interface AppDAO {
    void save (Instructor theInstrutor);

    Instructor findInstructor (int theId);

    void deleteInstructorById (int theId);

    InstructorDetail findInstructorDetailById (int theId);

    void deleteInstructorDetailById (int theId);
}









