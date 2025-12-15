package com.task.array.observer.impl;

import com.task.array.entity.ArrayStatistics;
import com.task.array.entity.CustomizedArray;
import com.task.array.observer.ArrayObserver;
import com.task.array.warehouse.ArrayWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayObserverImpl implements ArrayObserver {

    private static final Logger logger = LogManager.getLogger();
    private final ArrayWarehouse warehouse = ArrayWarehouse.getInstance();

    @Override
    public void changePerformed(CustomizedArray array) {

        if (array == null) {
            logger.error("Observer received null array");
            return;
        }

        int id = array.getId();
        logger.info("Observer: array {} changed, recalculating statistics...", id);

        try {
            int[] elements = array.getArray();

            int min = java.util.Arrays.stream(elements).min().orElse(0);
            int max = java.util.Arrays.stream(elements).max().orElse(0);
            int sum = java.util.Arrays.stream(elements).sum();

            ArrayStatistics stats = new ArrayStatistics(min, max, sum);

            warehouse.put(id, stats);

            logger.info("Warehouse updated for array {}: {}", id, stats);

        } catch (Exception e) {
            logger.error("Failed to update statistics for array {}", id, e);
        }
    }
}
