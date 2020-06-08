package hr.tvz.kerhin.studapp.controllers;

import hr.tvz.kerhin.studapp.models.DTO.CourseDTO;
import hr.tvz.kerhin.studapp.services.implementatios.CoursServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.List;

@RestController
@RequestMapping("course")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {

    @Autowired
    CoursServiceImpl coursService;

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping
    public List<CourseDTO> getAllCourses(){
        return coursService.getAll();
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping("/courses")
    public List<CourseDTO> getStudentCourses(@RequestParam(name = "jmbag") final String jmbag){
        return coursService.findCourseByUser(jmbag);
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping("/semester")
    public List<CourseDTO> getBySemester(@RequestParam (name = "semester") String name){
        return coursService.findBySemester(name);
    }
}
