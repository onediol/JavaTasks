package com.task.array.validator.impl;

import java.util.Arrays;
import java.util.regex.Pattern;

public class ArrayValidatorImpl {

    private static final Pattern VALID_LINE_PATTERN =
            Pattern.compile("^\\s*((-?\\d+(\\.\\d+)?\\s*([,;\\-\\s]|–)\\s*)*-?\\d+(\\.\\d+)?|)\\s*$");

    private static final Pattern SPLIT_PATTERN =
            Pattern.compile("[,;\\-\\s]|–");

    public boolean isValidArrayLine(String line) {
        return line != null
                && !line.isBlank()
                && VALID_LINE_PATTERN.matcher(line).matches();
    }

    public String[] splitValidLine(String line) {
        if (line == null || line.isBlank()) {
            return new String[0];
        }

        return Arrays.stream(SPLIT_PATTERN.split(line.strip()))
                .map(String::strip)
                .filter(s -> !s.isBlank())
                .toArray(String[]::new);
    }
}
