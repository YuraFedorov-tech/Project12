package ru.yura.web.controller;

import org.springframework.web.bind.annotation.*;
import ru.yura.web.model.User;
import ru.yura.web.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/")
public class UserRestController {


    final private
    UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping(value = "admin/add")
    public User addUser(User user, @RequestParam(required = false, name = "role_id") Long id, HttpServletRequest req) {
        userService.add(user, id);
        return user;
    }

    @PostMapping(value = "admin/delete")
    public User deleteUser(@RequestParam(required = false, name = "idDelete") Long id ) {
        User user = userService.findById(id);
        userService.delete(user);
        return user;
    }

    @PostMapping(value = "admin/update")
    public User postUpdateUser(User user, @RequestParam(required = false, name = "role_id") Long[] ids) {
        User userUpdate= userService.update(user, ids);
        return userUpdate;
    }
}