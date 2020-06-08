package hr.tvz.kerhin.studapp.models;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private Set<Authority> authorities = new HashSet<>();


    public User (Optional<User> user){
        this.id = user.get().getId();
        this.username = user.get().getUsername();
        this.password = user.get().getPassword();
        this.firstName = user.get().getFirstName();
        this.lastName = user.get().getLastName();
        this.authorities = user.get().getAuthorities();
    }

    public User (){}
}
