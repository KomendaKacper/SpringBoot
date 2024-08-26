package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.Student;

import java.util.List;

public interface AppDAO {
    void save (Instructor theInstrutor);

    Instructor findInstructor (int theId);

    void deleteInstructorById (int theId);

    List<Course> findCoursesByInstructorId (int theId);

    Instructor findInstructorByIdJoinFetch (int theId);

    void update(Instructor theInstrutor);

    void update(Course tempCourse);

    Course findCourseById (int theId);

    void deleteCourseById (int theId);

    void save(Course theCourse);

    Course findCourseAndReviewsByCourseId(int theId);

    Course findCourseAndStudentsByCourseId(int theId);

    Student findStudentAndCoursesByStudentId(int theId);

    void update(Student theStudent);

    void deleteStudentById (int theId);
}
