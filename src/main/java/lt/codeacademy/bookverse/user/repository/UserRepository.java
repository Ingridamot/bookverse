package lt.codeacademy.bookverse.user.repository;

import java.util.Optional;

import lt.codeacademy.bookverse.user.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);
}
