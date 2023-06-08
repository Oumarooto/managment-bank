package bank.managment.backend.service;

import bank.managment.backend.entities.Role;

import java.util.List;
import java.util.Optional;

public interface IRoleService {

    Role save(Role role);
    Optional<Role> findById(Long id);
    List<Role> findAll();
    Optional<Role> findByCode(String code);
}
