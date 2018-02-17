package com.spring.hibernate;

import org.hibernate.Criteria;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Kizurashi on 2/12/2018.
 */
public interface HibernateDao<T> {

    List<T> getAll();

    T get( Serializable var1 );

    void save( T var1 );

    void merge( T content );

    void delete(T var1);

    void delete(Serializable var1);

    Criteria createCriteria( );

}
