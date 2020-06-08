package hr.tvz.kerhin.studapp.models.DTO;

import hr.tvz.kerhin.studapp.models.Semester;
import lombok.Data;

@Data
public class CourseDTO {

    private String name;

    private int numberOfECTS;

   // private Semester semester;

    public CourseDTO(String name, int numberOfECTS) {
        this.name = name;
        this.numberOfECTS = numberOfECTS;
    }
}
