package ru.yura.web.security.securityDitel;

/*
 *
 *@Data 20.03.2020
 *@autor Fedorov Yuri
 *@project spring_security
 *
 */


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.yura.web.model.User;
import ru.yura.web.serviceRest.RestServiceImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    final
    RestServiceImpl restService;

    public UserDetailsServiceImpl(RestServiceImpl restService) {
        this.restService = restService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = restService.findModelByName(email);
        return user == null ? null : user;
    }
}