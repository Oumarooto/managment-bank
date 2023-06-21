package bank.managment.backend.controller.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInRequest {

    private String login;
    private String password;
}
