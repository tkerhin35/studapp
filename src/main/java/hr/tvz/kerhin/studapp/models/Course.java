package hr.tvz.kerhin.studapp.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Optional;
import java.util.Set;

@Data
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "ects_number")
    private int numberOfECTS;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Student.class)
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Student> students;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "semester_id")
    private Semester semester;

    public Course (Long id, String name, int numberOfECTS, Set<Student> students, Semester semester){
        this.id = id;
        this.name = name;
        this.numberOfECTS = numberOfECTS;
        this.students = students;
        this.semester = semester;
    }

    public Course(){}

    public Course(Optional<Course> course) {
        this.id = course.get().getId();
        this.name = course.get().getName();
        this.numberOfECTS = course.get().getNumberOfECTS();
        this.semester = course.get().getSemester();
        this.students = course.get().getStudents();
    }
}
