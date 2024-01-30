package lt.codeacademy.bookverse.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lt.codeacademy.bookverse.validation.PhoneNumber;
import lt.codeacademy.bookverse.validation.RepeatPassword;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@RepeatPassword
public class UserDto {
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String repeatPassword;
    @NotBlank
    private String zipCode;
    @NotBlank
    @PhoneNumber
    private String phoneNumber;
}
