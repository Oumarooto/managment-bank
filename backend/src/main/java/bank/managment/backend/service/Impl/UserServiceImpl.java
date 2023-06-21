package bank.managment.backend.service.Impl;

import bank.managment.backend.entities.User;
import bank.managment.backend.repositories.UserRepository;
import bank.managment.backend.service.IUserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    UserRepository userRepository;
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public List<User> findAll() {
        return Streamable.of(userRepository.findAll()).toList();
    }

    @Override
    public List<User> findByRoleCode(String code) {
        return userRepository.findByRoleCode(code);
    }

}
