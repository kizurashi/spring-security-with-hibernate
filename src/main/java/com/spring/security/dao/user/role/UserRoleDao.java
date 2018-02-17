package com.spring.security.dao.user.role;

import com.spring.hibernate.HibernateDao;
import com.spring.security.dao.user.role.model.UserRole;

import java.util.List;

/**
 * Created by Kizurashi on 2/12/2018.
 */
public interface UserRoleDao extends HibernateDao<UserRole> {

    void saveUserRole( UserRole role );

    void updateUserRole( Integer roleId, UserRole role );

    void deleteUserRole( Integer roleId );

    UserRole getUserRole( Integer roleId );

    List<UserRole> getUserRoles();

    UserRole findRole( String role );

}
