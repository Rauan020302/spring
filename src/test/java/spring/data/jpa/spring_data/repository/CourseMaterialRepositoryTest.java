package spring.data.jpa.spring_data.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.data.jpa.spring_data.entity.Course;
import spring.data.jpa.spring_data.entity.CourseMaterial;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void SaveCourseMaterial() {
        Course course =
                Course.builder()
                        .title(".net")
                        .credits(7)
                        .build();
        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                .url("www.youtube.com")
                .course(course)
                .build();
        courseMaterialRepository.save(courseMaterial);
    }
    @Test
    public void printAllCourseMaterials() {
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println("Course Materials list - " + courseMaterials);
    }

}