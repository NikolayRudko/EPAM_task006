package com.epam.task.six.data;

import com.epam.task.six.exception.DataException;

import java.util.List;

public interface DataAcquirer {

    List<String> getData() throws DataException;
}
