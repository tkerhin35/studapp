package hr.tvz.kerhin.studapp.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "jmbag")
    private String JMBAG;

    @Column(name = "number_of_ects")
    private int numberOfECTS;
    
    @ManyToMany( targetEntity = Course.class)
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses;

    public Student(String name, String surname, LocalDate dateOfBirth, String JMBAG, int numberOfECTS) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.JMBAG = JMBAG;
        this.numberOfECTS = numberOfECTS;
    }

    public Student(){}

}
