package com.epam.task.six.dao.comparator;

import com.epam.task.six.model.Book;

import java.util.Comparator;

public class TitleBookComparator implements Comparator<Book> {
    @Override
    public int compare(Book firstBook, Book secondBook) {

        String firstBookTitle = firstBook.getTitle();
        String secondBookTitle = secondBook.getTitle();

        if ((firstBookTitle == null) && (secondBookTitle  == null)) {
            return 0;
        }

        if (firstBookTitle == null) {
            return -1;
        }

        if (secondBookTitle == null) {
            return 1;
        }

        return firstBookTitle.compareToIgnoreCase(secondBookTitle);
    }
}
