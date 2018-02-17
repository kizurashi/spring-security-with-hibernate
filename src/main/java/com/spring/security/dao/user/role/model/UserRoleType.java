package com.spring.security.dao.user.role.model;

import java.io.Serializable;

/**
 * Created by Kizurashi on 2/12/2018.
 */
public enum UserRoleType implements Serializable {
    USER ( "USER" ),
    DBA ( "DBA" ),
    ADMIN ( "ADMIN" );

    String userRoleType;

    private UserRoleType ( String userRoleType ) {
        this.userRoleType = userRoleType;
    }

    @Override
    public String toString( ) {
        return this.userRoleType;
    }

}
