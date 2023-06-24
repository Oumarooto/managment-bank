package bank.managment.backend.config.security;

import bank.managment.backend.entities.Credentials;
import bank.managment.backend.entities.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


@Getter
@Setter
public class UserDetailsImpl implements UserDetails {

    private String username;
    private String password;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(User user, Credentials credentials){
        this.username = user.getLogin();
        this.password = credentials.getPassword();
        this.accountNonExpired = credentials.isAccountNonExpired();
        this.accountNonLocked = credentials.isAccountNonLocked();
        this.credentialsNonExpired = credentials.isCredentialsNonExpired();
        this.enabled = credentials.isEnabled();
    }


}
