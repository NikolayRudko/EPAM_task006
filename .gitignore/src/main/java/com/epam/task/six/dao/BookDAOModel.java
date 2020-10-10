package com.epam.task.six.dao;

import com.epam.task.six.dao.factory.BookField;
import com.epam.task.six.dao.factory.ComparatorFactory;
import com.epam.task.six.dao.factory.SpecificationFactory;
import com.epam.task.six.dao.specification.Specification;
import com.epam.task.six.exception.DAOBookException;
import com.epam.task.six.model.Book;

import java.util.*;

public class BookDAOModel implements BookDAO {

    private final List<Book> bookList = new ArrayList<>();
    private final SpecificationFactory specificationFactory = new SpecificationFactory();
    private final ComparatorFactory comparatorFactory = new ComparatorFactory();

    @Override
    public void add(Book book) throws DAOBookException {
        if (bookList.contains(book)) {
            throw new DAOBookException("This book has been added.");
        }
        bookList.add(book);
    }

    @Override
    public void add(List<Book> books) throws DAOBookException {
        for (Book newBook : books) {
            add(newBook);
        }
    }

    @Override
    public void remove(Book book) throws DAOBookException {
        if (!bookList.contains(book)) {
            throw new DAOBookException("The book was not found.");
        }
        bookList.remove(book);
    }

    @Override
    public <T> List<Book> findByTag(BookField field, T name) throws DAOBookException {
        Specification specification = specificationFactory.create(field);
        return specification.find(bookList, name);
    }

    @Override
    public List<Book> sortByTag(BookField field) {
        List<Book> sortedList = new ArrayList<>(bookList);
        Comparator comparator = comparatorFactory.create(field);
        sortedList.sort(comparator);

        return sortedList;
    }

    private StringBuffer bookInfo() {
        StringBuffer bookListInfo = new StringBuffer();

        for (Book book : bookList) {
            bookListInfo.append(book.toString()).append("\n");
        }
        return bookListInfo;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s", BookDAOModel.class.getSimpleName(), bookInfo().toString());
    }
}
