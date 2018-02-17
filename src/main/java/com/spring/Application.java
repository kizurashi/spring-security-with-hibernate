package com.spring;

import com.spring.hibernate.session.HibernateSessionFactory;

import com.spring.security.dao.user.UserDao;
import com.spring.security.dao.user.model.User;
import com.spring.security.dao.user.role.UserRoleDao;
import com.spring.security.dao.user.role.model.UserRole;
import io.toro.integrate.security.oauth.dao.model.ESBOAuth2AccessToken;
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
import sun.plugin.util.UserProfile;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Kizurashi on 2/11/2018.
 */
@SpringBootApplication
@ComponentScan( value = "com.spring")
@ImportResource( value = "bean.xml" )
public class Application {

    Logger logger = LoggerFactory.getLogger( this.getClass() );

    public static void main( String[] args ) {
        SpringApplication.run( Application.class, args);
        AppConfig c = new AppConfig();

        User u = new User();
        u.setFirstname("GENM");
        u.setLastname("GENM");
        u.setEmailAdd("GENM");
        u.setPassword("DJfkl");
        u.setUsername("Melody   ");
        Set<UserRole> userProfile = new HashSet<UserRole>();
        UserRole userRole = new UserRole();
        userRole.setRole("DBA");
        UserRole role1 = new UserRole();
        role1.setRole("ADMIN");
        userProfile.add( userRole );
        userProfile.add( role1 );

    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }
}
