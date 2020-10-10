package com.epam.task.six.dao.comparator;

import com.epam.task.six.model.Book;

import java.util.Comparator;

public class AuthorBookComparator implements Comparator<Book> {
    @Override
    public int compare(Book firstBook, Book secondBook) {

        String firstBookAuthor = firstBook.getAuthor();
        String secondBookAuthor = secondBook.getAuthor();

        if ((firstBookAuthor == null) && (secondBookAuthor  == null)) {
            return 0;
        }

        if (firstBookAuthor == null) {
            return -1;
        }

        if (secondBookAuthor== null) {
            return 1;
        }

        return firstBookAuthor.compareToIgnoreCase(secondBookAuthor);
    }
}
