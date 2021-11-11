package ca.jrf.jpa.repository;

import ca.jrf.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String name);

    Student findByFirstNameAndLastName(String firstName, String lastName);

    @Query("select s from Student s where s.email = ?1")
    Student getStudentByEmailAddress(String email);

    @Query("select s.firstName from Student s where s.email = ?1")
    String getStudentByFirstNameByEmailAddress(String email);

    @Query(value = "SELECT * FROM tbl_student s where s.email_address = :email", nativeQuery = true)
    Student getStudentByEmailAddressNativeNamed(@Param("email") String email);

    @Modifying
    @Transactional
    @Query(value = "update tbl_student set first_name = ?1 where email_address = ?2", nativeQuery = true)
    int updateStudentNameByEmail(String firstName, String email);
}
