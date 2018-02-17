package com.spring;

import com.spring.hibernate.session.HibernateSessionFactory;
import com.spring.security.dao.user.model.User;
import com.spring.security.dao.user.role.UserRoleDao;
import com.spring.security.dao.user.role.model.UserRole;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Kizurashi on 2/13/2018.
 */
@RestController
@ResponseBody
@RequestMapping( value = "/")
public class WebController {

    @Autowired
    UserRoleDao userRoleDao;

    Logger logger = LoggerFactory.getLogger( this.getClass() );

    @RequestMapping( value = "/users", method= RequestMethod.GET )
    public List<UserRole> getUsers() {
        return userRoleDao.getUserRoles();
    }

}
