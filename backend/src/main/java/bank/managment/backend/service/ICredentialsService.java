package bank.managment.backend.service;

import bank.managment.backend.entities.Credentials;
import bank.managment.backend.entities.Role;

import java.util.List;
import java.util.Optional;

public interface ICredentialsService {

    Credentials save(Credentials credentials);
    Optional<Credentials> findById(Long id);
    Optional<Credentials> findByLogin(String login);
}
