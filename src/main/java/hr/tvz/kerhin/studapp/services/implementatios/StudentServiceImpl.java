package hr.tvz.kerhin.studapp.services.implementatios;

import hr.tvz.kerhin.studapp.CourseRepository;
import hr.tvz.kerhin.studapp.StudentCommand;
import hr.tvz.kerhin.studapp.StudentRepository;
import hr.tvz.kerhin.studapp.models.Course;
import hr.tvz.kerhin.studapp.models.Student;
import hr.tvz.kerhin.studapp.models.DTO.StudentDTO;
import hr.tvz.kerhin.studapp.models.User;
import hr.tvz.kerhin.studapp.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private static final int YEARS_AFTER_TUITION_SHOULD_BE_PAYED = 26;

    private final StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream().map(this::mapStudentToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<StudentDTO> findStudentByJMBAG(String JMBAG) {
        return Optional.ofNullable(studentRepository.findStudentByJMBAG(JMBAG)).map(this::mapStudentToDTO);
    }

    @Override
    public Optional<StudentDTO> addStudent(StudentCommand command) {

        Student student = new Student(command.getFirstName(), command.getLastName(), command.getDateOfBirth(),
                command.getJmbag(), command.getNumberOfECTS());

        studentRepository.save(student);

        return Optional.ofNullable(mapStudentToDTO(student));
    }

    @Override
    public void deleteByJMBAG(String jmbag) {

        Student student = studentRepository.findStudentByJMBAG(jmbag);

        System.out.println(student.getJMBAG());

        studentRepository.delete(student);
    }

    @Override
    public Optional<StudentDTO> update(String jmbag, StudentCommand command) {

        Student student = studentRepository.findStudentByJMBAG(jmbag);

        if (student != null){
            student.setName(command.getFirstName());
            student.setSurname(command.getLastName());
            student.setJMBAG(command.getJmbag());
            student.setNumberOfECTS(command.getNumberOfECTS());

            studentRepository.save(student);

            return Optional.ofNullable(mapStudentToDTO(student));
        }

        return Optional.empty();
    }

    @Override
    public List<StudentDTO> findByCourses(Long id) {

        Optional<Course> course = courseRepository.findById(id);

        if (course.isPresent()){
            Course targetCourse = new Course(course);

            return studentRepository.findByCourses(targetCourse).stream().map(this::mapStudentToDTO).collect(Collectors.toList());
        }

        return new ArrayList<>();

    }

    private StudentDTO mapStudentToDTO(final Student student){
        return new StudentDTO(student.getName(), student.getSurname(), student.getJMBAG(),
                student.getNumberOfECTS(), shouldTuitionBePayed(student.getDateOfBirth()),
                student.getDateOfBirth());
    }

    private boolean shouldTuitionBePayed(LocalDate dateOfBirth){
        return dateOfBirth.plusYears(YEARS_AFTER_TUITION_SHOULD_BE_PAYED).isBefore(LocalDate.now());
    }
}
