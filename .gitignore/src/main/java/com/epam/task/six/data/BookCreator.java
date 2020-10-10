package com.epam.task.six.data;

import com.epam.task.six.exception.ParseException;
import com.epam.task.six.model.Book;
import com.epam.task.six.parser.BookParser;

import java.util.ArrayList;
import java.util.List;

public class BookCreator {

    private final BookParser bookParser;

    public BookCreator(BookParser bookParser) {
        this.bookParser = bookParser;
    }

    public List<Book> create(List<String> data) throws ParseException {

        List<Book> bookList = new ArrayList<>();

        for (String line : data) {
            Book book = bookParser.parse(line);
            bookList.add(book);
        }
        return bookList;
    }
}
