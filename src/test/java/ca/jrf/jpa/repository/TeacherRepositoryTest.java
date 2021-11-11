package ca.jrf.jpa.repository;

import ca.jrf.jpa.entity.Course;
import ca.jrf.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course course = Course.builder().title("prog101").credit(5).build();
        Course course2 = Course.builder().title("java").credit(6).build();
      //  Teacher teacher  = Teacher.builder().firstName("Sam").lastName("Smith").courses(List.of(course,course2)).build();
    }

}