package com.epam.task.six.data;

import com.epam.task.six.exception.DataException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataAcquirer implements  DataAcquirer {

    private final String fileName;

    public FileDataAcquirer(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<String> getData() throws DataException {

        List<String> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            throw new DataException(e);
        }

        return data;
    }
}
