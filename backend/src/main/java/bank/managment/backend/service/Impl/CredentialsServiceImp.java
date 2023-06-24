package bank.managment.backend.service.Impl;

import bank.managment.backend.entities.Credentials;
import bank.managment.backend.repositories.CredentialsRepository;
import bank.managment.backend.service.ICredentialsService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class CredentialsServiceImp implements ICredentialsService {

    CredentialsRepository credentialsRepository;
    @Override
    public Credentials save(Credentials credentials) {
        return credentialsRepository.save(credentials);
    }

    @Override
    public Optional<Credentials> findById(Long id) {
        return credentialsRepository.findById(id);
    }

    @Override
    public Optional<Credentials> findByLogin(String login) {
        return credentialsRepository.findByLogin(login);
    }
}
