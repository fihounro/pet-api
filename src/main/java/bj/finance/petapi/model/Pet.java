package bj.finance.petapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.IdentityHashMap;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pet extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @ManyToOne(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinColumn(name = "pet_type_id")
    private PetType petType;

    @ManyToOne(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinColumn(name = "owner_id")
    private Owner owner;
    private LocalDate birthDate;

    private Gender gender;
}
