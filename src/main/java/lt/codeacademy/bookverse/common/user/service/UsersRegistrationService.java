package lt.codeacademy.bookverse.common.user.service;

import java.util.Set;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.bookverse.common.user.dto.UserDto;
import lt.codeacademy.bookverse.jpa.entities.Authority;
import lt.codeacademy.bookverse.jpa.entities.User;
import lt.codeacademy.bookverse.jpa.repositories.AuthorityRepository;
import lt.codeacademy.bookverse.jpa.repositories.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersRegistrationService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(UserDto userDto) throws DataIntegrityViolationException {
        final Set<Authority> authorities = authorityRepository.findAll().stream()
                .filter(authority -> authority.getName().equals("USER"))
                .collect(Collectors.toSet());

        userRepository.save(
                User.builder()
                        .name(userDto.getName())
                        .surname(userDto.getSurname())
                        .email(userDto.getEmail())
                        .phoneNumber(userDto.getPhoneNumber())
                        .zipCode(userDto.getZipCode())
                        .password(passwordEncoder.encode(userDto.getPassword()))
                        .authorities(authorities)
                        .build()
        );
    }
}

