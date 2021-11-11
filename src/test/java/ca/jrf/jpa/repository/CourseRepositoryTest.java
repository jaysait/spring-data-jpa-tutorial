package ca.jrf.jpa.repository;

import ca.jrf.jpa.entity.Course;
import ca.jrf.jpa.entity.Student;
import ca.jrf.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    CourseRepository courseRepository;

    @Test
    public void printCourse(){
        List<Course>courses = courseRepository.findAll();
        System.out.println("courses: "+courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder().lastName("Gap").firstName("Front").build();
        Course course = Course.builder().credit(2).title("python").teacher(teacher).build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPagewithThreeRecords = PageRequest.of(0,3);

        Pageable secondPageWithTwoRecords = PageRequest.of(1,2);

        List<Course> courses = courseRepository.findAll(firstPagewithThreeRecords).getContent();


        System.out.println("..."+courses);
    }
    @Test
    public void findAllSorting(){
        Pageable sortByTitle = PageRequest.of(0,2, Sort.by("title").and(Sort.by("credit")));
        Pageable sortByCredit = PageRequest.of(0,2, Sort.by("credit").descending());
        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher = Teacher.builder().firstName("Mary").lastName("Pollock").build();
        Student student = Student.builder().email("2@2.com").firstName("Kyle").lastName("Sing").build();
        Course course = Course.builder().title("ai").credit(3).teacher(teacher).build();

        course.addStudents(student);

        courseRepository.save(course);
    }

}