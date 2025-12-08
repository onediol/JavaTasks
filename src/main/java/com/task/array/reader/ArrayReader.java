package com.task.array.reader;

import com.task.array.exceptions.ArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayReader {
    private static final Logger logger = LogManager.getLogger();

    public static List<String> readLines(String filePath) throws ArrayException {
        if (filePath == null || filePath.trim().isEmpty()) {
            throw new ArrayException("File path cannot be null or empty");
        }

        File file = new File(filePath);
        if (!file.exists()) {
            throw new ArrayException("File does not exist: " + filePath);
        }

        if (!file.canRead()) {
            throw new ArrayException("File cannot be read: " + filePath);
        }

        try (Stream<String> lineStream = Files.lines(Paths.get(filePath))) {
            logger.info("Reading file from path: {}", filePath);
               return lineStream.collect(Collectors.toList());
        } catch (IOException e) {
            logger.error("Error reading file: {}", filePath, e);
            throw new ArrayException("Error reading file: " + filePath, e);
        }
    }
}