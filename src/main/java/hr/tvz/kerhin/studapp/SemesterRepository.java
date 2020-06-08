package hr.tvz.kerhin.studapp;

import hr.tvz.kerhin.studapp.models.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepository extends JpaRepository<Semester, Long> {

    Semester findByName(String name);
}
