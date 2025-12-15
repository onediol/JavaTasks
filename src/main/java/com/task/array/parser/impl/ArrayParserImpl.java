package com.task.array.parser.impl;

import com.task.array.exception.ArrayException;
import com.task.array.validator.impl.ArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ArrayParserImpl {

    private static final Logger logger = LogManager.getLogger();
    private static final String REGEX_PATTERN = "[,;\\s-]+";

    private final ArrayValidatorImpl validator = new ArrayValidatorImpl();

    public int[] parse(String line) throws ArrayException {

        if (line == null || line.isBlank()) {
            logger.error("Input line is null or blank");
            throw new ArrayException("Input line cannot be null or blank");
        }

        if (!validator.isValidArrayLine(line)) {
            logger.error("Invalid line format: {}", line);
            throw new ArrayException("Line contains invalid characters: " + line);
        }

        try {
            int[] result = Arrays.stream(line.strip().split(REGEX_PATTERN))
                    .map(String::strip)
                    .filter(s -> !s.isBlank())
                    .mapToInt(Integer::parseInt)
                    .toArray();

            logger.info("Successfully parsed line: '{}' into array of size {}", line, result.length);
            return result;

        } catch (NumberFormatException e) {
            logger.error("Error parsing number in line: {}", line, e);
            throw new ArrayException("Error parsing number in line: " + line, e);
        }
    }
}
