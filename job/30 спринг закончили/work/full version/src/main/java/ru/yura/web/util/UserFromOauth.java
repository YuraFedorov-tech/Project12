package ru.yura.web.util;
/*
 *
 *@Data 10.04.2020
 *@autor Fedorov Yuri
 *@project Bootstrap3.1.3
 *
 */

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import ru.yura.web.model.User;
import ru.yura.web.service.UserService;

import java.util.Map;

public class UserFromOauth {


    public static User findUser(Authentication authentication, UserService userService) {
        try {
            OAuth2AuthenticationToken oAuth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;
            Map<String, Object> map = oAuth2AuthenticationToken.getPrincipal().getAttributes();
            String email = (String) map.get("email");
            String firstName = (String) map.get("given_name");
            String lastName = (String) map.get("family_name");
            try {
                return userService.findModelByName(email);
            } catch (org.springframework.dao.EmptyResultDataAccessException ex) {
                User newUser = new User().setEmail(email).setFirstName(firstName).setLastName(lastName);
                userService.add(newUser, 459L);
                return newUser;
            }
        } catch (ClassCastException ex) {
            return (User) authentication.getPrincipal();
        }
    }
}
