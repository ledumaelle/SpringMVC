package fr.maelle.filmotheque.dao;

import fr.maelle.filmotheque.exception.DAOException;

import java.util.List;

public interface GenericDAO<T,U> {

    void add(T entity) throws DAOException;

    void update(T entity) throws DAOException;

    void delete(T entity) throws DAOException;

    T findById(Class c, U id) throws DAOException;

    List<T> findAll(Class c) throws DAOException;

}
