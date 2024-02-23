package lt.codeacademy.bookverse.security.jpa.repository;

import lt.codeacademy.bookverse.security.jpa.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
