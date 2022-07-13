package bj.finance.petapi.model.security;

import bj.finance.petapi.model.BaseEntity;
import bj.finance.petapi.model.Person;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = {"email", "username"}))
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(nullable = false, unique = true)
    private String username;
   // @NotNull
    private String email;
   // @NotNull
    private String password;
    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    // When we retrieve a User we want the role to be retrieved
    @ManyToMany(cascade={CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
    joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;

    public User() {
    }

    public User(String username, String email, String password, Person person) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.person = person;
    }

    public User(String username, String email, String password, Person person, Set<Role> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.person = person;
        this.roles = roles;
    }
}
