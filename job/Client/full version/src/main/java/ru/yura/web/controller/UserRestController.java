package ru.yura.web.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.yura.web.model.User;
import ru.yura.web.serviceRest.RestServiceImpl;

@RestController
@RequestMapping("/")
public class UserRestController {


    final
    RestServiceImpl restService;

    public UserRestController(RestServiceImpl restService) {
        this.restService = restService;
    }


    @PostMapping(value = "admin/add")
    public User addUser(User user, @RequestParam(required = false, name = "role_id") Long id) {
        return restService.add(user, id);
    }

    @PostMapping(value = "admin/delete")
    public User deleteUser(@RequestParam(required = false, name = "idDelete") Long id) {
        User user = restService.findById(id);
        restService.delete(user);
        return user;
    }

    @PostMapping(value = "admin/update")
    public User postUpdateUser(User user, @RequestParam(required = false, name = "role_id") Long[] ids) {
        return restService.update(user, ids);
    }
}