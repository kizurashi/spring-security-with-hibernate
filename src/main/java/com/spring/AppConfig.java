package com.spring;

import com.spring.security.dao.user.role.UserRoleDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

class AppConfig {

    @Autowired
    UserRoleDao userRoleDao;

    Logger logger = LoggerFactory.getLogger( this.getClass() );

    public UserRoleDao save( ) {
        userRoleDao.getAll();
        return userRoleDao;
    }
}