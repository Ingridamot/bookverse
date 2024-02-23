package lt.codeacademy.bookverse.security.registration.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.bookverse.security.cases.UsersRegistrationService;
import lt.codeacademy.bookverse.security.domain.UserDomain;
import lt.codeacademy.bookverse.security.registration.dto.UserRegistrationDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCreateService {

    private final UsersRegistrationService usersRegistrationService;

    public void createUser(UserRegistrationDto userRegistrationDto) {
        usersRegistrationService.register(UserDomain.builder()
                .name(userRegistrationDto.getName())
                .surname(userRegistrationDto.getSurname())
                .email(userRegistrationDto.getEmail())
                .phoneNumber(userRegistrationDto.getPhoneNumber())
                .zipCode(userRegistrationDto.getZipCode())
                .password(userRegistrationDto.getPassword())
                .build());
    }
}

