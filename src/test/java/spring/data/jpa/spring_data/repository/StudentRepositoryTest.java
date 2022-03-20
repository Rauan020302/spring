package spring.data.jpa.spring_data.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.data.jpa.spring_data.entity.Guardian;
import spring.data.jpa.spring_data.entity.Student;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("Rauan@gmail.com")
                .firstName("Rauan")
                .lastName("Maksut")
                //.guardianName("Ron")
                //.guardianEmail("Ron@gmail.com")
                //.guardianMobile("123123123")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("Ronaldo")
                .email("Ronaldo@gmail.com")
                .mobile("123456789").build();

        Student student = Student.builder()
                .emailId("Messi@gmail.com")
                .firstName("Messi")
                .lastName("Leo")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }
    @Test
    public void printAllStudents(){
        List<Student> students = studentRepository.findAll();
        System.out.println("Students list - " + students);
    }
    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Messi");
        System.out.println("Students list by name - " + students );
    }
    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("ssi");
        System.out.println("Students list by name containing - " + students );
    }
    @Test
    public void printStudentByLastNameNotNull() {
        List<Student> students = studentRepository.findByLastNameNotNull();
        System.out.println("Students list by last name not null - " + students );
    }
    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("Ronaldo");
        System.out.println("Students list by GuardianName - " + students );
    }
    @Test
    public void printStudentByFirstAndLastName() {
        List<Student> students = studentRepository.findByFirstNameAndLastName("Messi","Leo");
        System.out.println("Students list by first and last name - " + students );
    }
    @Test
    public void printStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailId("Rauan@gmail.com");
        System.out.println("student - " + student);
    }
    @Test
    public void printStudentFirstNameByEmailAddress() {
        String studentFirstName = studentRepository.getStudentFirstNameByEmailId("Rauan@gmail.com");
        System.out.println("student - " + studentFirstName);
    }
    @Test
    public void printStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailIdNative("Rauan@gmail.com");
        System.out.println("student - " + student);
    }

    @Test
    public void printStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailIdNativeNamedParam("Rauan@gmail.com");
        System.out.println("student - " + student);
    }
    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameByEmailId("Lewandowski",
                "Messi@gmail.com");
    }


}