package com.epam.task.six.dao;

import com.epam.task.six.dao.factory.BookField;
import com.epam.task.six.exception.DAOBookException;
import com.epam.task.six.model.Book;

import java.util.List;

public interface BookDAO {

    void add(Book book) throws DAOBookException;

    void add(List<Book> books) throws DAOBookException;

    void remove(Book book) throws DAOBookException;

    <T> List<Book> findByTag(BookField field, T name) throws DAOBookException;

    List<Book> sortByTag(BookField field);
}
