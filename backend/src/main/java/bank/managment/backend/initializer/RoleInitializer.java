package bank.managment.backend.initializer;

import bank.managment.backend.entities.Role;
import bank.managment.backend.service.IRoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
@Order(1)
public class RoleInitializer implements CommandLineRunner {

    IRoleService roleService;
    @Override
    public void run(String... args) throws Exception {

        if (!roleService.findByCode("ADMIN").isPresent()){
            Role role1 = new Role();
            role1.setCode("ADMIN");
            role1.setLabel("Bank Administrator");
            roleService.save(role1);
        }

        roleService.findAll()
                .stream()
                .forEach(role -> {
                    System.out.println(role.getId() + " " + role.getCode() + " " + role.getLabel());
                });

    }
}
