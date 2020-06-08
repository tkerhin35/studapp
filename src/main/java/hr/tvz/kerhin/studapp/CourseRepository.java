package hr.tvz.kerhin.studapp;

import hr.tvz.kerhin.studapp.models.Course;
import hr.tvz.kerhin.studapp.models.Semester;
import hr.tvz.kerhin.studapp.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//ovo je neki komentar
//ovo je neki komentar2
//ovo je neki komentar3
//ovo je neki komentar4
@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

    @Override
    List<Course> findAll();

    List<Course> findByStudents(Student student);

    List<Course> findBySemester(Semester semester);

    Optional<Course> findById(Long id);
}
