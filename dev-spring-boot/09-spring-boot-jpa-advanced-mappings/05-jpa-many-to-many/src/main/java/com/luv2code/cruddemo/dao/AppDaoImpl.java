package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDaoImpl implements AppDAO{

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public AppDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructor(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {

        // retrieve the instructor
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);

        // get the courses
        List<Course> coursers = tempInstructor.getCourses();

        // break association of all courses for the instructor
        for (Course course : coursers) {
            course.setInstructor(null);
        }

        // delete the instructor
        entityManager.remove(tempInstructor);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {

        // create query
        TypedQuery<Course> query = entityManager.createQuery(
                                "from Course where instructor.id =:data", Course.class);
        query.setParameter("data", theId);

        // execute query
        List<Course> courses = query.getResultList();

        return courses;

    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {

        // create query
        TypedQuery<Instructor> query = entityManager.createQuery(
                                                "select i from Instructor i "
                                                + "JOiN FETCH i.courses "
                                                + "JOIN FETCH i.instructorDetail "
                                                + "where i.id =:data", Instructor.class);

        query.setParameter("data", theId);

        // execute query
        Instructor instructor = query.getSingleResult();
        return instructor;
    }

    @Transactional
    @Override
    public void update(Instructor theInstrutor) {
        entityManager.merge(theInstrutor);
    }

    @Override
    @Transactional
    public void update(Course tempCourse) {
        entityManager.merge(tempCourse);
    }

    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class, theId);
    }

    @Transactional
    @Override
    public void deleteCourseById(int theId) {
        Course tempCourse = entityManager.find(Course.class, theId);
        entityManager.remove(tempCourse);
    }

    @Transactional
    @Override
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int theId) {

        // create a query
        TypedQuery<Course> query = entityManager.createQuery(
                    "select c from Course c "
                    + "JOIN FETCH c.reviews "
                    + "where c.id = :data", Course.class);
        query.setParameter("data", theId);

        // execute query
        Course course = query.getSingleResult();

        return course;
    }

    @Override
    public Course findCourseAndStudentsByCourseId(int theId) {

        // create query
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c "
                        + "JOIN FETCH c.students "
                        + "where c.id = :data", Course.class);
        query.setParameter("data", theId);

        // execute query
        Course course = query.getSingleResult();
        return course;
    }

    @Override
    public Student findStudentAndCoursesByStudentId(int theId) {

        // create query
        TypedQuery<Student> query = entityManager.createQuery(
                "select s from Student s "
                        + "JOIN FETCH s.courses "
                        + "where s.id = :data", Student.class);
        query.setParameter("data", theId);

        // execute query
        Student student = query.getSingleResult();

        return student;
    }

    @Transactional
    @Override
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Transactional
    @Override
    public void deleteStudentById(int theId) {
        Student tempStudent = entityManager.find(Student.class, theId);

        entityManager.remove(tempStudent);
    }
}
