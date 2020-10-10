package com.epam.task.six.dao.specification;

import com.epam.task.six.exception.DAOBookException;
import com.epam.task.six.model.Book;

public class IdSpecification<T> extends AbstractSpecification<T> {
    @Override
    public boolean matchesField(Book book, T value) throws DAOBookException {

        int id = book.getId();
        int compareId;

        if (value instanceof Integer) {
            compareId = (Integer) value;
        } else {
            throw new DAOBookException("Incorrect type value" + value);
        }
        return id == compareId;
    }
}
