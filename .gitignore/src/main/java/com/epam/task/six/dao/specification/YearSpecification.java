package com.epam.task.six.dao.specification;

import com.epam.task.six.exception.DAOBookException;
import com.epam.task.six.model.Book;

public class YearSpecification<T> extends AbstractSpecification<T> {
    @Override
    public boolean matchesField(Book book, T value) throws DAOBookException {
        int year = book.getYear();
        int compareYear;

        if (value instanceof Integer) {
            compareYear = (Integer) value;
        } else {
            throw new DAOBookException("Incorrect type value" + value);
        }
        return year == compareYear;
    }
}
