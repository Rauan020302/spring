package spring.data.jpa.spring_data.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.data.jpa.spring_data.entity.Course;
import spring.data.jpa.spring_data.entity.Teacher;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course courseDBA = Course.builder()
                .title("DBA")
                .credits(5)
                .build();
        Course courseJava = Course.builder()
                .title("Java")
                .credits(4)
                .build();
        Teacher teacher = Teacher
                .builder()
                .firstName("Ancelotti")
                .lastName("Carlo")
                //.courses(List.of(courseDBA,courseJava))
                .build();
        teacherRepository.save(teacher);
    }


}