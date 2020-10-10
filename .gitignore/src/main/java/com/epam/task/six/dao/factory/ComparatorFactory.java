package com.epam.task.six.dao.factory;

import com.epam.task.six.dao.comparator.*;
import com.epam.task.six.model.Book;

import java.util.Comparator;

public class ComparatorFactory {
    public Comparator<Book> create(BookField bookField) {
        switch (bookField) {
            case ID:
                return new IdBookComparator();
            case YEAR:
                return new YearBookComparator();
            case PAGES:
                return new PagesBookComparator();
            case TITLE:
                return  new TitleBookComparator();
            case AUTHOR:
                return  new AuthorBookComparator();
            default:
                throw new IllegalArgumentException("Incorrect type of books field" + bookField.name());
        }
    }
}
