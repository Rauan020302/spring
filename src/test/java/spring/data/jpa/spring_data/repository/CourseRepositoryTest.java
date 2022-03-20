package spring.data.jpa.spring_data.repository;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import spring.data.jpa.spring_data.entity.Course;
import spring.data.jpa.spring_data.entity.Student;
import spring.data.jpa.spring_data.entity.Teacher;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourse() {
        List<Course> courses = courseRepository.findAll();
        System.out.println("course list - " + courses);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher
                .builder()
                .lastName("Muller")
                .firstName("Tomas")
                .build();
        Course course = Course
                .builder()
                .title("C++")
                .credits(6)
                .teacher(teacher).build();
        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords =
                PageRequest.of(0, 3);
        Pageable secondPageWithThreeRecords =
                PageRequest.of(1, 2);

        List<Course> courses =
                courseRepository.findAll(firstPageWithThreeRecords).getContent();

        long totalElements = courseRepository.findAll(firstPageWithThreeRecords)
                .getTotalElements();

        long totalPages = courseRepository.findAll(firstPageWithThreeRecords)
                .getTotalPages();

        System.out.println("total pages - " + totalPages);

        System.out.println("total elements - " + totalElements);

        System.out.println("course list - " + courses);
    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle = PageRequest.of(
                0,
                3,
                Sort.by("title")
        );
        Pageable sortByCreditDesc = PageRequest.of(
                0,
                3,
                Sort.by("credits").descending()
        );
        Pageable sortByTitleAndCreditDesc = PageRequest.of(
                0,
                3,
                Sort.by("title")
                        .descending()
                        .and(Sort.by("credits      ")
                                .descending())
        );

        List<Course> courses = courseRepository.findAll(sortByTitleAndCreditDesc).getContent();
        System.out.println("course " + courses);
    }

    @Test
    public void printCourseByTitleContaining() {
        Pageable firstPageTenRecords = PageRequest.of(
                0, 10);
        List<Course> courses = courseRepository.findByTitleContaining(
                "D", firstPageTenRecords);
        System.out.println("course " + courses);
    }
    @Test
    public void saveCourseWithStudentAndTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Federico")
                .lastName("Valverde")
                .build();
        Student student = Student.builder()
                .firstName("Philipp")
                .lastName("Lahm")
                .emailId("Lahm@gmail.com")
                .build();

        Course course = Course.builder()
                .title("AI")
                .credits(2)
                .teacher(teacher)
                .build();
        course.addStudents(student);
        courseRepository.save(course);
    }

}