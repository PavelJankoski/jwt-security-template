package finki.security.example.repository;

import finki.security.example.domain.enums.ERole;
import finki.security.example.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);

}
