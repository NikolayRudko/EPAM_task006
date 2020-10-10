package com.epam.task.six.dao.specification;

import com.epam.task.six.exception.DAOBookException;
import com.epam.task.six.model.Book;

import java.util.List;

public interface Specification<T> {


    List<Book> find(List<Book> books, T value) throws DAOBookException;
}
