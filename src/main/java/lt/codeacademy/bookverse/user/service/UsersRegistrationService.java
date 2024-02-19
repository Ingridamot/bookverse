package lt.codeacademy.bookverse.user.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.bookverse.user.dto.UserDto;
import lt.codeacademy.bookverse.user.pojo.Authority;
import lt.codeacademy.bookverse.user.pojo.User;
import lt.codeacademy.bookverse.user.repository.AuthorityRepository;
import lt.codeacademy.bookverse.user.repository.UserRepository;
import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

