package bj.finance.petapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Owner extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "owner"
    )
    private Set<Pet> pets = new HashSet<>();
}
