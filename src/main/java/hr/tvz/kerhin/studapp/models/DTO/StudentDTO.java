package hr.tvz.kerhin.studapp.models.DTO;

import java.time.LocalDate;

public class StudentDTO {

    private String firstName;
    private String lastName;
    private String jmbag;
    private int numberOfECTS;
    private boolean tuitionShouldBePaid;
    private LocalDate dateOfBirth;


    public StudentDTO(String firstName, String lastName, String jmbag,
                      int numberOfECTS, boolean tuitionShouldBePaid, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jmbag = jmbag;
        this.numberOfECTS = numberOfECTS;
        this.tuitionShouldBePaid = tuitionShouldBePaid;
        this.dateOfBirth = dateOfBirth;
    }

    public String getJmbag() {
        return jmbag;
    }

    public void setJmbag(String jmbag) {
        this.jmbag = jmbag;
    }

    public int getNumberOfECTS() {
        return numberOfECTS;
    }

    public void setNumberOfECTS(int numberOfECTS) {
        this.numberOfECTS = numberOfECTS;
    }

    public boolean isTuitionShouldBePaid() {
        return tuitionShouldBePaid;
    }

    public void setTuitionShouldBePaid(boolean tuitionShouldBePaid) {
        this.tuitionShouldBePaid = tuitionShouldBePaid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}

