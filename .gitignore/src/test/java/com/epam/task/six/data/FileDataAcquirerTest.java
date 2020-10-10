package com.epam.task.six.data;

import com.epam.task.six.exception.DataException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FileDataAcquirerTest {

    private final static String TEST_DATA = "src/test/resources/testData.txt";
    private final static String TEST_ERROR_DATA = "src/test/resources/errorData.txt";

    private final static List<String> ACTUAL_DATA = Arrays.asList(
            "Fist First 1",
            "Second 2",
            "Third");

    @Test
    public void testShouldReadDataFromFile() throws DataException {
        //given
        DataAcquirer dataAcquirer = new FileDataAcquirer(TEST_DATA);

        //when
        List<String> expected = dataAcquirer.getData();

        //then
        Assert.assertEquals(expected, ACTUAL_DATA);
    }

    @Test(expected = DataException.class)
    public void testShouldTrowDataExceptionWhenFileDontExist() throws DataException {
        //given
        DataAcquirer dataAcquirer = new FileDataAcquirer(TEST_ERROR_DATA);
        //when
        List<String> expected = dataAcquirer.getData();
    }

}