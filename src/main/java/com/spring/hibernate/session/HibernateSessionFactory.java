package com.spring.hibernate.session;

import com.spring.hibernate.HibernateDao;
import com.spring.security.dao.user.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PersistenceException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Kizurashi on 1/21/2018.
 */
public abstract class HibernateSessionFactory<T> implements HibernateDao<T> {

    public Class clazz;

    private static SessionFactory sessionFactory;

    Logger logger = LoggerFactory.getLogger( this.getClass() );


    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    protected Session getSession( ) {
        return getSessionFactory().getCurrentSession();
    }

    public String getClazz() {
        String[] t = (((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getTypeName().split("\\.");
        return t[ t.length - 1 ];
    }

    @Override
    public List<T> getAll() {
        Query query = getSession().createQuery( String.format( "from %s", getClazz() ) );
        try {
            return query.list();
        } catch ( PersistenceException e ) {
            throw new PersistenceException( e );
        }
    }

    @Override
    public T get( Serializable var1 ) {
        return (T) getSession().get( getClazz(), var1 );
    }

    @Override
    public void save(T var1) {
        getSession().saveOrUpdate( var1 );
    }

    @Override
    public void delete(T var1) {
        getSession().delete( var1 );
    }

    @Override
    public void merge(T var1) {
        getSession().merge( var1 );
    }

    @Override
    public void delete(Serializable var1) {
        getSession().delete( getClazz(), var1 );
    }

    @Override
    public Criteria createCriteria() {
        return getSession().createCriteria( getClazz() );
    }

}
