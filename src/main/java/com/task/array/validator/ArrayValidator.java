package com.task.array.validator;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Arrays;

public class ArrayValidator {
    private static final Pattern VALID_LINE_PATTERN =
            Pattern.compile("^\\s*((-?\\d+(\\.\\d+)?\\s*([,;\\-\\s]|–)\\s*)*-?\\d+(\\.\\d+)?|)\\s*$");

    private static final Pattern SPLIT_PATTERN =
            Pattern.compile("[,;\\-\\s]|–");

    private static final Pattern NUMBER_PATTERN =
            Pattern.compile("-?\\d+(\\.\\d+)?");

    public boolean isValidArrayLine(String line) {
        if (line == null) {
            return false;
        }

        if (line.trim().isEmpty()) {
            return true;
        }

        Matcher matcher = VALID_LINE_PATTERN.matcher(line);
        return matcher.matches();
    }

    public String[] splitValidLine(String line) {
        if (line == null || line.trim().isEmpty()) {
            return new String[0];
        }

        String[] tokens = SPLIT_PATTERN.split(line.trim());

        return Arrays.stream(tokens)
                .filter(token -> !token.trim().isEmpty())
                .map(String::trim)
                .toArray(String[]::new);
    }


    public int[] parseIntArray(String line) {
        if (!isValidArrayLine(line) || line.trim().isEmpty()) {
            return new int[0];
        }

        String[] stringTokens = splitValidLine(line);

        return Arrays.stream(stringTokens)
                .filter(NUMBER_PATTERN.asMatchPredicate())
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}