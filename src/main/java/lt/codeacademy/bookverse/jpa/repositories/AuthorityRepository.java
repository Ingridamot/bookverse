package lt.codeacademy.bookverse.jpa.repositories;

import lt.codeacademy.bookverse.jpa.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
