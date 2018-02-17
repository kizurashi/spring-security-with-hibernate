package com.spring.security.dao.user.impl;

import com.spring.hibernate.session.HibernateSessionFactory;
import com.spring.security.dao.user.UserDao;
import com.spring.security.dao.user.model.User;
import com.spring.security.dao.user.role.UserRoleDao;
import com.spring.security.dao.user.role.model.UserRole;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Kizurashi on 2/12/2018.
 */
@Transactional
public class UserDaoImpl extends HibernateSessionFactory<User> implements UserDao {

    @Autowired
    UserRoleDao userRoleDao;
    Logger logger = LoggerFactory.getLogger( this.getClass() );

    UserDaoImpl( SessionFactory sessionFactory ) {
        super.setSessionFactory( sessionFactory);
        this.clazz = this.getClass();
    }

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
        logger.warn(  super.get( userId ).toString() );
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
