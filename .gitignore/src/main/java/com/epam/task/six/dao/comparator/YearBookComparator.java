package com.epam.task.six.dao.comparator;

import com.epam.task.six.model.Book;

import java.util.Comparator;

public class YearBookComparator implements Comparator<Book> {

    @Override
    public int compare(Book firstBook, Book secondBook) {
        int firstBookYear = firstBook.getYear();
        int secondBookYear = secondBook.getYear();

        return firstBookYear - secondBookYear;
    }
}
