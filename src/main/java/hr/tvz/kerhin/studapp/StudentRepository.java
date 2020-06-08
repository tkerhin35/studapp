package hr.tvz.kerhin.studapp;

import hr.tvz.kerhin.studapp.models.Course;
import hr.tvz.kerhin.studapp.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAll();

    Student findStudentByJMBAG(final String JMBAG);

    void deleteByJMBAG(String jmbag);

    List<Student> findByCourses(Course course);


}
