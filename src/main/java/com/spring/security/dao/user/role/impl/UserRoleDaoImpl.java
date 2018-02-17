package com.spring.security.dao.user.role.impl;

import com.spring.hibernate.session.HibernateSessionFactory;
import com.spring.security.dao.user.model.User;
import com.spring.security.dao.user.role.UserRoleDao;
import com.spring.security.dao.user.role.model.UserRole;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by Kizurashi on 2/12/2018.
 */
public class UserRoleDaoImpl extends HibernateSessionFactory<UserRole> implements UserRoleDao {

    UserRoleDaoImpl() {
        this.clazz = this.getClass();
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
