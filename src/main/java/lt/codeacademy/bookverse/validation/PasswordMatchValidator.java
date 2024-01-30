package lt.codeacademy.bookverse.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lt.codeacademy.bookverse.user.dto.UserDto;

public class PasswordMatchValidator implements ConstraintValidator<RepeatPassword, UserDto> {

    @Override
    public boolean isValid(UserDto userDto, ConstraintValidatorContext context) {
        return userDto.getPassword().equals(userDto.getRepeatPassword());
    }
}

