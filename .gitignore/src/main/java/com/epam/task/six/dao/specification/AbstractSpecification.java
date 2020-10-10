package com.epam.task.six.dao.specification;

import com.epam.task.six.exception.DAOBookException;
import com.epam.task.six.model.Book;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSpecification<T>  implements Specification<T>{

    public abstract boolean matchesField(Book book, T value) throws DAOBookException;

    @Override
    public List<Book> find(List<Book> books, T value) throws DAOBookException {

        List<Book> searchedBooks = new ArrayList<>();

        for (Book book : books) {
            if (matchesField(book, value)) {
                searchedBooks.add(book);
            }
        }
        return searchedBooks;
    }
}
