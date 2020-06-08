package hr.tvz.kerhin.studapp.controllers;

import hr.tvz.kerhin.studapp.UserRepository;
import hr.tvz.kerhin.studapp.models.Authority;
import hr.tvz.kerhin.studapp.models.DTO.UserDTO;
import hr.tvz.kerhin.studapp.models.User;
import hr.tvz.kerhin.studapp.security.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/user/current-user")
    public ResponseEntity<UserDTO> getCurrentUser(){

        Optional<User> user = repository.findOneByUsername(SecurityUtils.getCurrentUserUsername().orElse(""));

        if (user.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(mapUserToDTO(user));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    private UserDTO mapUserToDTO(final Optional<User> user){
        return new UserDTO(user.get().getId(), user.get().getUsername(), user.get().getFirstName(),
                user.get().getLastName(), auhtorityToString(user.get().getAuthorities()));
    }

    private Set<String> auhtorityToString(Set<Authority> authorities){

        return authorities.stream().map(this::mapAuthorityToString).collect(Collectors.toSet());

    }

    private String  mapAuthorityToString (Authority authority){

        String authorityString;

        switch (authority.getName()){
            case "ROLE_USER":
                authorityString = "ROLE_USER";
                break;
            case "ROLE_ADMIN":
                authorityString = "ROLE_ADMIN";
                break;
            default:
                authorityString = "Auhtority not found";
        }

        return authorityString;
    }

}
