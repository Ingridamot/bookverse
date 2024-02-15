package lt.codeacademy.bookverse.user.repository;

import lt.codeacademy.bookverse.user.pojo.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
