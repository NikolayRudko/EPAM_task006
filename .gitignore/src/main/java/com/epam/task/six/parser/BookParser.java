package com.epam.task.six.parser;

import com.epam.task.six.exception.ParseException;
import com.epam.task.six.model.Book;

public class BookParser {

    private final static String STRING_DELIMITER = "\\s+";

    public Book parse(String line) throws ParseException {

        String[] bookFields = line.trim().split(STRING_DELIMITER);
        int id;
        int year;
        int pages;
        try {
            id = Integer.parseInt(bookFields[0]);
            year = Integer.parseInt(bookFields[1]);
            pages = Integer.parseInt(bookFields[2]);
        } catch (NumberFormatException e) {
            throw new ParseException(e);
        }
        String title = bookFields[3];
        String author = bookFields[4];

        return new Book(id, year, pages, title, author);
    }
}
