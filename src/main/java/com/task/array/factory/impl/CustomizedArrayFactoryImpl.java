package com.task.array.factory.impl;

import com.task.array.entity.CustomizedArray;
import com.task.array.exceptions.ArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomizedArrayFactoryImpl {
    private static final Logger logger = LogManager.getLogger();

    public CustomizedArray createArray(int[] values) throws ArrayException {
        logger.info("Creating array with {} elements", values );
        return new CustomizedArray(values);
    }
}