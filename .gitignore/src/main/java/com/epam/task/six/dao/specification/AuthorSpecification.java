package com.epam.task.six.dao.specification;

import com.epam.task.six.exception.DAOBookException;
import com.epam.task.six.model.Book;

public class AuthorSpecification<T> extends AbstractSpecification<T> {
    @Override
    public boolean matchesField(Book book, T value) throws DAOBookException {
        String author = book.getAuthor();
        String compareAuthor;

        if (value instanceof String) {
            compareAuthor = (String) value;
        } else {
            throw new DAOBookException("Incorrect type value" + value);
        }
        return author.equals(compareAuthor);
    }
}
