package bank.managment.backend.service;

import bank.managment.backend.entities.Role;
import bank.managment.backend.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByLogin(String login);
    List<User> findAll();
    List<User> findByRoleCode(String code);
}
