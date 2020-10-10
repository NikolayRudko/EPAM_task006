package com.epam.task.six.parser;

import com.epam.task.six.exception.ParseException;
import com.epam.task.six.model.Book;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookParserTest {

    private final static String DATA = "912 1956 265 Lolita Vladimir_Nabokov";
    private final static String BROKEN_DATA = "912a 1956 265 Lolita Vladimir_Nabokov";


    private final static Book ACTUAL = new Book(912, 1956, 265, "Lolita", "Vladimir_Nabokov");

    @Test
    public void testShouldParseStringDataToBook() throws ParseException {
        //given
        BookParser parser = new BookParser();
        //when
        Book expected = parser.parse(DATA);
        //then
        Assert.assertEquals(expected, ACTUAL);
    }

    @Test(expected = ParseException.class)
    public void testShouldThrows() throws ParseException {
        //given
        BookParser parser = new BookParser();

        //when
        Book expected = parser.parse(BROKEN_DATA);
    }


}