package hr.tvz.kerhin.studapp.controllers;


import hr.tvz.kerhin.studapp.StudentCommand;
import hr.tvz.kerhin.studapp.services.interfaces.StudentService;
import hr.tvz.kerhin.studapp.models.DTO.StudentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("student")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping
    public List<StudentDTO> getAllStudents(){
        return studentService.findAll();
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping("/{JMBAG}")
    public ResponseEntity<StudentDTO> getStudentsByJMBAG(@PathVariable final String JMBAG){
        return studentService.findStudentByJMBAG(JMBAG)
                .map(
                    studentDTO -> ResponseEntity
                        .status(HttpStatus.OK)
                        .body(studentDTO)
                )
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.NOT_FOUND)
                                .build()
                );
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping
    public ResponseEntity<StudentDTO> addStudent(@Valid @RequestBody final StudentCommand command){
        return studentService.addStudent(command)
                .map(
                        studentDTO -> ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(studentDTO)
                )
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.BAD_REQUEST)
                                .build()
                );
    }

    @Secured({"ROLE_ADMIN", "ROLE_DELETER"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{JMBAG}")
    public void delete(@PathVariable String JMBAG){
        studentService.deleteByJMBAG(JMBAG);
    }

    @Secured({"ROLE_ADMIN"})
    @PutMapping("/{JMBAG}")
    public ResponseEntity<StudentDTO> update(@PathVariable String JMBAG,
                                             @Valid @RequestBody final StudentCommand command){

        return studentService.update(JMBAG, command)
                .map(ResponseEntity::ok)
                .orElseGet(
                        () -> ResponseEntity.notFound().build()
                );
    }

}
