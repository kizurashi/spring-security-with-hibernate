package com.spring.security.dao.user.role.impl;

import com.spring.hibernate.session.HibernateSessionFactory;
import com.spring.security.dao.user.model.User;
import com.spring.security.dao.user.role.UserRoleDao;
import com.spring.security.dao.user.role.model.UserRole;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Kizurashi on 2/12/2018.
 */
@Transactional
public class UserRoleDaoImpl extends HibernateSessionFactory<UserRole> implements UserRoleDao {

    Logger logger = LoggerFactory.getLogger( this.getClass() );

    public UserRoleDaoImpl( SessionFactory sessionFactory ) {
        super.setSessionFactory( sessionFactory );
        getClazz();
    }

    @Override
    public void saveUserRole(UserRole role) {
        super.save( role );
    }

    @Override
    public void updateUserRole(Integer roleId, UserRole role) {}

    @Override
    public void deleteUserRole(Integer roleId) {
        super.delete( roleId );
    }

    @Override
    public UserRole getUserRole(Integer roleId) {
        return super.get( roleId );
    }

    @Override
    public List<UserRole> getUserRoles() {
        return super.getAll();
    }

    @Override
    public UserRole findRole(String role) {
        Query query = getSession().createQuery(
                                        String.format( "from %s where role = :role ", getClazz() ) );
        query.setParameter( "role", role );
        return !query.list().isEmpty()? (UserRole)query.list().get( 0 ) : null;
    }
}
