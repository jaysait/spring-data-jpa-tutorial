package ca.jrf.jpa.repository;


import ca.jrf.jpa.entity.Guardian;
import ca.jrf.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder().email("jrf@gmail.com").firstName("Jay").lastName("Rich").build();
        //.guardianName("Goldie").guardianEmail("gold@gmail.com").guardianPhone("403-222-4455").build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder().phone("222-222-3333").email("gold@gmail.com").name("gold").build();
        Student student = Student.builder().email("lob@gmail.com").firstName("Lisa").lastName("Blen")
                .guardian(guardian).build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
        List<Student> students = studentRepository.findAll();
       students.stream().forEach(student -> System.out.println(student));

    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("Jay");
        System.out.println(students);
        List<Student> students2 = studentRepository.findByFirstNameContaining("ay");
        System.out.println(students2);
        List<Student> students3 = studentRepository.findByGuardianName("gold");
        System.out.println(students3);

    }

    @Test
    public void updateStudentNameByEmail(){
        studentRepository.updateStudentNameByEmail("Jason", "jrf@gmail.com");
    }
}