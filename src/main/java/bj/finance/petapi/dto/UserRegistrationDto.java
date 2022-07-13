package bj.finance.petapi.dto;

import bj.finance.petapi.model.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserRegistrationDto {

    @NotBlank
    private String username;

    @Email
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    //dd-MMM-yyyy
    @JsonFormat(pattern = "dd-MMM-yyyy")
    private String birthDate;
    private Gender Gender;
    private Long personId;

}
