package com.epam.task.six.dao.specification;

import com.epam.task.six.exception.DAOBookException;
import com.epam.task.six.model.Book;

public class PagesSpecification<T> extends AbstractSpecification<T> {

    @Override
    public boolean matchesField(Book book, T value) throws DAOBookException {
        int pages = book.getPages();
        int comparePages;

        if (value instanceof Integer) {
            comparePages = (Integer) value;
        } else {
            throw new DAOBookException("Incorrect type value" + value);
        }
        return pages == comparePages;
    }
}
