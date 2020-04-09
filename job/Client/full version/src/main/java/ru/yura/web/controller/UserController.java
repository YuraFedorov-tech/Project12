package ru.yura.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.yura.web.app.config.ConfigProperties;
import ru.yura.web.serviceRest.RestServiceImpl;

/*
 *
 *@Data 04.04.2020
 *@autor Fedorov Yuri
 *@project spring_security
 *
 */

@Controller
public class UserController {


    final
    RestServiceImpl restService;

    public UserController(RestServiceImpl restService) {
        this.restService = restService;
    }


    @GetMapping(value = "admin/admin")
    public String getAdminPanel(ModelMap modelMap, Authentication authentication) {
        modelMap.addAttribute("user", authentication.getPrincipal());
        modelMap.addAttribute("users", restService.findAll());
        return "crud";
    }

    @GetMapping(value = "user")
    public String seeUser(ModelMap modelMap, Authentication authentication) {
        modelMap.addAttribute("user", authentication.getPrincipal());
        return "seeUser";
    }
}
