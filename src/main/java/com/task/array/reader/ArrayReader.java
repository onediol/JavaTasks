package com.task.array.reader;

import com.task.array.exception.ArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayReader {

    private static final Logger logger = LogManager.getLogger();

    public static List<String> readLines(String filePath) throws ArrayException {

        if (filePath == null || filePath.isBlank()) {
            throw new ArrayException("File path cannot be null or blank");
        }

        Path path = Paths.get(filePath);

        if (!Files.exists(path)) {
            throw new ArrayException("File does not exist: " + filePath);
        }

        if (!Files.isReadable(path)) {
            throw new ArrayException("File cannot be read: " + filePath);
        }

        try (Stream<String> lines = Files.lines(path)) {
            logger.info("Reading file from path: {}", filePath);
            return lines.collect(Collectors.toList());
        } catch (IOException e) {
            logger.error("Error reading file: {}", filePath, e);
            throw new ArrayException("Error reading file: " + filePath, e);
        }
    }
}
