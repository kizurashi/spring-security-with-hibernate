package com.spring.security.dao.user.impl;

import com.spring.hibernate.session.HibernateSessionFactory;
import com.spring.security.dao.user.UserDao;
import com.spring.security.dao.user.model.User;
import com.spring.security.dao.user.role.UserRoleDao;
import com.spring.security.dao.user.role.model.UserRole;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Kizurashi on 2/12/2018.
 */
public class UserDaoImpl extends HibernateSessionFactory<User> implements UserDao {

    @Autowired
    UserRoleDao userRoleDao;

    @Override
    public void saveUser(User user) {
        if ( user != null ) {
            user.setUserProfiles( new HashSet<UserRole>() );
            for ( UserRole role : user.getUserProfiles() ) {
                user.getUserProfiles().add( userRoleDao.findRole( role.getRole() ) );
            }
            super.save( user );
        }
    }

    @Override
    public void updateUser(Integer userId, User user) {

    }

    @Override
    public void deleteUser(Integer userId) {
        super.delete( userId );
    }

    @Override
    public User getUser(Integer userId) {
        return (User) super.get( userId );
    }

    @Override
    public User getUserByUsername(String username) {
        Query query = getSession().createQuery(
                String.format( "from %s where username = :username ", getClazz() ) );
        query.setParameter( "role", username );
        return !query.list().isEmpty()? (User)query.list().get( 0 ) : null;
    }

    @Override
    public List<User> getUsers() {
        return super.getAll();
    }

}
