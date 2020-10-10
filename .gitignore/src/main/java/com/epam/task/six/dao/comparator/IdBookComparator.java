package com.epam.task.six.dao.comparator;

import com.epam.task.six.model.Book;

import java.util.Comparator;

public class IdBookComparator implements Comparator<Book> {

    @Override
    public int compare(Book firstBook, Book secondBook) {

        int firstBookId = firstBook.getId();
        int secondBookId = secondBook.getId();

        return firstBookId - secondBookId;
    }
}
