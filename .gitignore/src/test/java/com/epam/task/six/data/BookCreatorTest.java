package com.epam.task.six.data;

import com.epam.task.six.exception.ParseException;
import com.epam.task.six.model.Book;
import com.epam.task.six.parser.BookParser;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BookCreatorTest {
    private final static List<String> DATA = Arrays.asList(
            "12 1940 600 The_Lord_of_the_Rings R_R_Tolkien",
            "11 1950 596 The_Great_Gatsby Scott_Fitzgerald",
            "15 1962 632 Lord_of_the_Flies William_Golding");

    private final static List<Book> ACTUAL = Arrays.asList(
            new Book(12, 1940, 600, "The_Lord_of_the_Rings", "R_R_Tolkien"),
            new Book(11, 1950, 596, "The_Great_Gatsby", "Scott_Fitzgerald"),
            new Book(15, 1962, 632, "Lord_of_the_Flies", "William_Golding"));

    @Test
    public void testCreatorShouldCreateListOfBooks() throws ParseException {
        //given
        BookCreator creator = new BookCreator(new BookParser());

        //when
        List<Book> expected = creator.create(DATA);

        //then
        Assert.assertEquals(expected, ACTUAL);
    }
}