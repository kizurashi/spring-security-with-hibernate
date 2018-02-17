package com.spring.web.controller.user.role;

import com.spring.security.dao.user.UserDao;
import com.spring.security.dao.user.model.User;
import com.spring.security.dao.user.role.UserRoleDao;
import com.spring.security.dao.user.role.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by WKS on 2/17/2018.
 */
@RestController
@RequestMapping( "userRole" )
public class UserRoleController {

    @Autowired
    public UserRoleDao userRoleDao;

    @RequestMapping( value = "/", method = RequestMethod.GET )
    public List<UserRole> getUsers() {
        return userRoleDao.getUserRoles();
    }

    @RequestMapping( value = "/{userRoleId}", method = RequestMethod.GET )
    public UserRole getUserById(@PathVariable("userRoleId") Integer userId ) {
        return userRoleDao.getUserRole( userId );
    }

    @RequestMapping( value = "/", method = RequestMethod.POST )
    public void saveUser( @RequestBody UserRole userRole ) {
        userRoleDao.saveUserRole( userRole );
    }

    @RequestMapping( value = "/{userRoleId}", method = RequestMethod.DELETE )
    public void deleteUserRole( @PathVariable("userRoleId") Integer userId ) {
        userRoleDao.deleteUserRole( userId );
    }

    @RequestMapping( value = "/{userRoleId}", method = RequestMethod.PUT )
    public void updateUserRole( @PathVariable("userRoleId") Integer userId, @RequestBody UserRole userRole ) {
        userRoleDao.updateUserRole( userId, userRole );
    }

}
