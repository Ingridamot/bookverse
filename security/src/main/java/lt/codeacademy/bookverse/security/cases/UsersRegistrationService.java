package lt.codeacademy.bookverse.security.cases;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.bookverse.security.jpa.entity.Authority;
import lt.codeacademy.bookverse.security.jpa.entity.User;
import lt.codeacademy.bookverse.security.jpa.repository.AuthorityRepository;
import lt.codeacademy.bookverse.security.jpa.repository.UserRepository;
import lt.codeacademy.bookverse.security.domain.UserDomain;
import lt.codeacademy.bookverse.security.service.Encoder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersRegistrationService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final Encoder encoder;

    public void register(UserDomain userDomain) throws DataIntegrityViolationException {
        final Set<Authority> authorities = authorityRepository.findAll().stream()
                .filter(authority -> authority.getName().equals("USER"))
                .collect(Collectors.toSet());

        userRepository.save(
                User.builder()
                        .name(userDomain.getName())
                        .surname(userDomain.getSurname())
                        .email(userDomain.getEmail())
                        .phoneNumber(userDomain.getPhoneNumber())
                        .zipCode(userDomain.getZipCode())
                        .password(encoder.encode(userDomain.getPassword()))
                        .authorities(authorities)
                        .build()
        );
    }
}
