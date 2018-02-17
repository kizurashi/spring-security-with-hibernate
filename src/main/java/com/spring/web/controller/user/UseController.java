package com.spring.web.controller.user;

import com.spring.security.dao.user.UserDao;
import com.spring.security.dao.user.model.User;
import com.spring.security.dao.user.role.UserRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by WKS on 2/17/2018.
 */
@RestController
@RequestMapping( "users" )
public class UseController {

    @Autowired
    public UserDao userDao;

    @RequestMapping( value = "/", method = RequestMethod.GET )
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @RequestMapping( value = "/{userId}", method = RequestMethod.GET )
    public User getUserById( @RequestParam("userId") Integer userId ) {
        return userDao.getUser( userId );
    }

    @RequestMapping( value = "/", method = RequestMethod.POST )
    public void saveUser( @RequestBody User user ) {
        userDao.saveUser( user );
    }

    @RequestMapping( value = "/{userId}", method = RequestMethod.DELETE )
    public void deleteUser( @RequestParam("userId") Integer userId ) {
        userDao.deleteUser( userId );
    }

    @RequestMapping( value = "/{userId}", method = RequestMethod.PUT )
    public void updateUser( @RequestParam("userId") Integer userId, @RequestBody User user ) {
        userDao.updateUser( userId, user );
    }
}
