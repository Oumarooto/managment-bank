package bank.managment.backend.initializer;

import bank.managment.backend.entities.Credentials;
import bank.managment.backend.entities.Role;
import bank.managment.backend.entities.User;
import bank.managment.backend.repositories.CredentialsRepository;
import bank.managment.backend.service.ICredentialsService;
import bank.managment.backend.service.IRoleService;
import bank.managment.backend.service.IUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
@Order(2)
public class UserInitializer implements CommandLineRunner {
    private final CredentialsRepository credentialsRepository;

    IUserService userService;
    IRoleService roleService;
    ICredentialsService credentialsService;
    PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {

        Optional<User> adminOptional =   userService.findByLogin("oumzo");
        if (!adminOptional.isPresent()) {
            Optional<Role> roleAdminOptional = roleService.findByCode("ADMIN");
            if (roleAdminOptional.isPresent()) {
                User admin = new User();
                admin.setRole(roleAdminOptional.get());
                admin.setEmail("admin@oumzo.org");
                admin.setFirstName("Oumaruto");
                admin.setLastName("Uzumaki");
                admin.setLogin("oumzo");
                userService.save(admin);

                Credentials credentials = new Credentials();
                String encodedPassword = encoder.encode("12345");
                credentials.setPassword(encodedPassword);
                credentials.setLogin(admin.getLogin());
                credentials.setAccountNonExpired(true);
                credentials.setAccountNonLocked(true);
                credentials.setCredentialsNonExpired(true);
                credentials.setEnabled(true);
                credentialsService.save(credentials);
            }
        }
    }
}
