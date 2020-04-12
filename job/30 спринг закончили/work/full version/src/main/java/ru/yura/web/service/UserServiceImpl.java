package ru.yura.web.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yura.web.dao.RoleDao;
import ru.yura.web.dao.UserDao;
import ru.yura.web.model.Role;
import ru.yura.web.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    final private
    UserDao userDao;

    final private
    RoleDao roleDao;

    public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Transactional
    @Override
    public void add(User model, Long id) {
        userDao.add(model);
        model.addRoles(roleDao.findById(id));
    }

    @Transactional
    @Override
    public User update(User model, Long[] ids) {
        User user = userDao.update(model);
        insideRoles(user, ids);
        return user;
    }

    public void insideRoles(User model, Long[] ids) {
        List<Role> newRoles = new ArrayList<>();
        for (Long id : ids) {
            Role role = roleDao.findById(id);
            newRoles.add(role);
        }
        model.setRoles(newRoles);
    }

    @Transactional(readOnly = true)
    @Override
    public User findModelByName(String name) {
        return userDao.findModelByName(name);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public User findById(Long id) {

        return userDao.findById(id);
    }

    @Transactional
    @Override
    public void delete(User user) {
        userDao.delete(user);
    }


    @Override
    public void drop() {
        userDao.drop();
    }


    @Override
    public void create() {
        userDao.create();
    }
}
