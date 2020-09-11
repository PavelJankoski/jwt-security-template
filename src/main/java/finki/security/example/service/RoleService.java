package finki.security.example.service;

import finki.security.example.domain.model.Role;

import java.util.Set;

public interface RoleService {
    Set<Role> extractRoles(Set<String> strRoles);
}
