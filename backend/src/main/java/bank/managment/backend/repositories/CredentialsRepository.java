package bank.managment.backend.repositories;

import bank.managment.backend.entities.Credentials;
import bank.managment.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CredentialsRepository extends JpaRepository<Credentials, Long> {
    Optional<Credentials> findByLogin(String login);
}
