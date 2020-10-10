package com.epam.task.six.dao.comparator;

import com.epam.task.six.model.Book;

import java.util.Comparator;

public class PagesBookComparator implements Comparator<Book> {
    @Override
    public int compare(Book firstBook, Book secondBook) {
        int firstBookPages = firstBook.getPages();
        int secondBookPages = secondBook.getPages();

        return firstBookPages - secondBookPages;
    }
}
