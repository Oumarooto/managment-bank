package bank.managment.backend.initializer;

import bank.managment.backend.entities.Role;
import bank.managment.backend.entities.User;
import bank.managment.backend.service.IRoleService;
import bank.managment.backend.service.IUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
@Order(2)
public class UserInitializer implements CommandLineRunner {

    IUserService userService;
    IRoleService roleService;

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
            }
        }
    }
}
