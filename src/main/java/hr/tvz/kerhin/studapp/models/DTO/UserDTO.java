package hr.tvz.kerhin.studapp.models.DTO;

import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {

    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    private Set<String> authorities;

    public UserDTO(Long id, String username, String firstName,
                   String lastName, Set<String> authorities){
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.authorities = authorities;
    }
}
