package hr.tvz.kerhin.studapp.services.interfaces;

import java.util.List;
import hr.tvz.kerhin.studapp.models.DTO.CourseDTO;

public interface CourseService {

    List<CourseDTO> getAll();

    List<CourseDTO> findCourseByUser(String jmbag);

    List<CourseDTO> findBySemester(String name);
}
