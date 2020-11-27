package ru.indivio.homecrm.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.indivio.homecrm.entities.SystemUser;
import ru.indivio.homecrm.entities.User;


public interface UserService extends UserDetailsService {
    User findByUserName(String username);
    boolean save(SystemUser systemUser);

}
