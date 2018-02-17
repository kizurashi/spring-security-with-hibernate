package com.spring.security.dao.user;

import com.spring.hibernate.HibernateDao;
import com.spring.security.dao.user.model.User;

import java.util.List;

/**
 * Created by Kizurashi on 2/12/2018.
 */
public interface UserDao extends HibernateDao<User> {

    void saveUser( User user );

    void updateUser( Integer userId, User user );

    void deleteUser( Integer userId );

    User getUser( Integer userId );

    User getUserByUsername ( String username );

    List<User> getUsers();
}
