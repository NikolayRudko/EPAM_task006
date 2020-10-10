package com.epam.task.six.dao.specification;

import com.epam.task.six.exception.DAOBookException;
import com.epam.task.six.model.Book;

public class TitleSpecification<T> extends AbstractSpecification<T> {
    @Override
    public boolean matchesField(Book book, T value) throws DAOBookException {
        String title = book.getTitle();
        String compareTitle;

        if (value instanceof String) {
            compareTitle = (String) value;
        } else {
            throw new DAOBookException("Incorrect type value" + value);
        }
        return title.equals(compareTitle);
    }
}
