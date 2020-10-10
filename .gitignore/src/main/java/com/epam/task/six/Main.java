package com.epam.task.six;

import com.epam.task.six.dao.BookDAO;
import com.epam.task.six.dao.BookDAOModel;
import com.epam.task.six.dao.factory.BookField;
import com.epam.task.six.data.BookCreator;
import com.epam.task.six.data.DataAcquirer;
import com.epam.task.six.data.FileDataAcquirer;
import com.epam.task.six.exception.DAOBookException;
import com.epam.task.six.exception.DataException;
import com.epam.task.six.exception.ParseException;
import com.epam.task.six.model.Book;
import com.epam.task.six.parser.BookParser;
import org.apache.log4j.Logger;

import java.util.List;

public class Main {

    private final static Logger LOGGER = Logger.getLogger(Main.class.getSimpleName());
    private final static String FILE_DATA = "bookData.txt";

    public static void main(String[] args) {
        try {
            process();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    private static void process() throws DataException, ParseException, DAOBookException {

        //read data
        LOGGER.info("Start the program.");
        DataAcquirer dataAcquirer = new FileDataAcquirer(FILE_DATA);
        List<String> bookData = dataAcquirer.getData();

        //create list of books
        LOGGER.info("Read: " + FILE_DATA);
        BookParser parser = new BookParser();
        BookCreator creator = new BookCreator(parser);
        LOGGER.info("Create the list of books.");
        List<Book> bookList = creator.create(bookData);

        //create DAO
        LOGGER.info("Create the DAO.");
        BookDAO bookDAO = new BookDAOModel();
        bookDAO.add(bookList);
        LOGGER.info(bookDAO);

        //sort
        LOGGER.info("Sort by year");
        bookDAO.sortByTag(BookField.YEAR);
        LOGGER.info(bookDAO);

        //search by author
        LOGGER.info("Search by author.");
        List<Book> searchBooks = bookDAO.findByTag(BookField.AUTHOR, "George_Orwell");
        LOGGER.info(searchBooks);

    }
}
