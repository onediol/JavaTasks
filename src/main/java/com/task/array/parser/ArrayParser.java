package com.task.array.parser;

import com.task.array.exception.ArrayException;

public interface ArrayParser {
    int[] parse(String line) throws ArrayException;
}
