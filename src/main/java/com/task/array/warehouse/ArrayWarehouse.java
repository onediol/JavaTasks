package com.task.array.warehouse;

import com.task.array.entity.ArrayStatistics;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class ArrayWarehouse {

    private static final Logger logger = LogManager.getLogger();

    private static ArrayWarehouse instance;

    private final Map<Integer, ArrayStatistics> storage;

    private ArrayWarehouse() {
        this.storage = new HashMap<>();
    }

    public static ArrayWarehouse getInstance() {
        if (instance == null) {
            instance = new ArrayWarehouse();
            logger.info("ArrayWarehouse singleton created");
        }
        return instance;
    }

    public void put(Integer arrayId, ArrayStatistics statistics) {
        if (arrayId == null) {
            logger.error("Attempted to put statistics with null ID");
            return;
        }
        storage.put(arrayId, statistics);
        logger.info("Statistics stored for array {}: {}", arrayId, statistics);
    }

    public ArrayStatistics get(Integer arrayId) {
        if (arrayId == null) {
            logger.error("Attempted to get statistics with null ID");
            return null;
        }
        return storage.get(arrayId);
    }

    public void remove(Integer arrayId) {
        if (arrayId == null) {
            logger.error("Attempted to remove statistics with null ID");
            return;
        }
        storage.remove(arrayId);
        logger.debug("Statistics removed for array {}", arrayId);
    }

    public void update(Integer arrayId, ArrayStatistics statistics) {
        put(arrayId, statistics);
    }
}
