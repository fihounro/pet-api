package bj.finance.petapi.dto;

import bj.finance.petapi.model.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetDto {

    @NotBlank
    private String name;

    private Long petTypeId;
    private Long ownerId;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private LocalDate birthDate;
    @NotBlank
    private String gender;
}
