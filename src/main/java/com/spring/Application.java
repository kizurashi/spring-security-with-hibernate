package com.spring;

import com.spring.hibernate.session.HibernateSessionFactory;

import com.spring.security.dao.user.UserDao;
import com.spring.security.dao.user.model.User;
import com.spring.security.dao.user.role.UserRoleDao;
import com.spring.security.dao.user.role.model.UserRole;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import sun.plugin.util.UserProfile;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Kizurashi on 2/11/2018.
 */
@SpringBootApplication
@EnableTransactionManagement
@ComponentScan( value = "com.spring")
@ImportResource( value = "bean.xml" )
public class Application {

    Logger logger = LoggerFactory.getLogger( this.getClass() );

    public static void main( String[] args ) {
        SpringApplication.run(Application.class, args);
    }

}
