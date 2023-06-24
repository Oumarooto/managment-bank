package bank.managment.backend.config.security.service;

import bank.managment.backend.config.security.UserDetailsImpl;
import bank.managment.backend.entities.Credentials;
import bank.managment.backend.entities.User;
import bank.managment.backend.service.ICredentialsService;
import bank.managment.backend.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    IUserService userService;
    ICredentialsService credentialsService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userService.findByLogin(username);
        if (userOptional.isPresent()) {
            Optional<Credentials> optionalCredentials = credentialsService.findByLogin(username);
            if (optionalCredentials.isPresent()) {
                return new UserDetailsImpl(userOptional.get(), optionalCredentials.get());
            }
        }
        return null;
    }
}
