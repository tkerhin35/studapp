package hr.tvz.kerhin.studapp.services.implementatios;

import hr.tvz.kerhin.studapp.CourseRepository;
import hr.tvz.kerhin.studapp.SemesterRepository;
import hr.tvz.kerhin.studapp.StudentRepository;
import hr.tvz.kerhin.studapp.models.Course;
import hr.tvz.kerhin.studapp.models.DTO.CourseDTO;
import hr.tvz.kerhin.studapp.models.Semester;
import hr.tvz.kerhin.studapp.models.Student;
import hr.tvz.kerhin.studapp.services.interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.List;

@Service
public class CoursServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SemesterRepository semesterRepository;

    @Override
    public List<CourseDTO> getAll() {
        return courseRepository.findAll().stream().map(this::mapCoursetoCourseDTO).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> findCourseByUser(String jmbag) {
        Student student = studentRepository.findStudentByJMBAG(jmbag);

        List<Course> courses = courseRepository.findByStudents(student);

        return courses.stream().map(this::mapCoursetoCourseDTO).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> findBySemester(String name) {
        Semester semester = semesterRepository.findByName(name);

        return courseRepository.findBySemester(semester).stream().map(this::mapCoursetoCourseDTO).collect(Collectors.toList());
    }

    private CourseDTO mapCoursetoCourseDTO(final Course course){

        return new CourseDTO(course.getName(), course.getNumberOfECTS());
    }
}
