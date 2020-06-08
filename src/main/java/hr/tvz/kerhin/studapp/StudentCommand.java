package hr.tvz.kerhin.studapp;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class StudentCommand {

    @NotBlank(message = "First name must not be empty")
    private String firstName;

    @NotBlank(message = "Surname must not be empty")
    private String lastName;

    //@JsonFormat(pattern = "dd.MM.yyyy.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "Date of birth be entered")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @NotBlank(message = "JMBAG must be entered")
    @Pattern(message = "JMBAG must have 10 digits", regexp = "[\\d]{10}")
    private String jmbag;

    @NotNull(message = "Number of ECTS points must be entered")
    @PositiveOrZero(message = "Number of ECTS points must be entered as positive integer")
    @Max(message = "Number of ECTS can not be higher than 480", value = 480)
    private int numberOfECTS;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getJmbag() {
        return jmbag;
    }

    public int getNumberOfECTS() {
        return numberOfECTS;
    }
}
