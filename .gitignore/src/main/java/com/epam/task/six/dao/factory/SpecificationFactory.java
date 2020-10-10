package com.epam.task.six.dao.factory;

import com.epam.task.six.dao.specification.*;

public class SpecificationFactory {
    public Specification create(BookField bookField) {
        switch (bookField) {
            case ID:
                return new IdSpecification();
            case YEAR:
                return new YearSpecification();
            case PAGES:
                return new PagesSpecification();
            case TITLE:
                return new TitleSpecification();
            case AUTHOR:
                return new AuthorSpecification();
            default:
                throw new IllegalArgumentException("Incorrect type of books field" + bookField.name());
        }
    }
}
