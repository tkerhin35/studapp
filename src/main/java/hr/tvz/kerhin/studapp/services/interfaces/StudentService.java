package hr.tvz.kerhin.studapp.services.interfaces;

import hr.tvz.kerhin.studapp.StudentCommand;
import hr.tvz.kerhin.studapp.models.Course;
import hr.tvz.kerhin.studapp.models.DTO.StudentDTO;
import hr.tvz.kerhin.studapp.models.Student;

import java.util.*;

public interface StudentService {

    List<StudentDTO> findAll();

    Optional<StudentDTO> findStudentByJMBAG(final String JMBAG);

    Optional<StudentDTO> addStudent(StudentCommand command);

    List<StudentDTO> findByCourses(Long id);

    void deleteByJMBAG(String jmabg);

    Optional<StudentDTO> update(String jmbag, StudentCommand command);

}
