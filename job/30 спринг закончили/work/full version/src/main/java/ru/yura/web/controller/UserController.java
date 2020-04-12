package ru.yura.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.yura.web.model.User;
import ru.yura.web.service.UserService;
import ru.yura.web.util.UserFromOauth;

/*
 *
 *@Data 04.04.2020
 *@autor Fedorov Yuri
 *@project spring_security
 *
 */

@Controller
public class UserController {

    final private
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "admin/admin")
    public String getAdminPanel(ModelMap modelMap, Authentication authentication) {
        User user = UserFromOauth.findUser(authentication, userService);
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("users", userService.findAll());
        return "crud";
    }


    @GetMapping(value = "user")
    public String seeUser(ModelMap modelMap, Authentication authentication) {
        User user = UserFromOauth.findUser(authentication, userService);
        modelMap.addAttribute("user", user);
        return "seeUser";
    }

}
