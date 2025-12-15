package com.task.array.service;

import com.task.array.entity.CustomizedArray;
import com.task.array.exception.ArrayException;

public interface SortService {
    void bubbleSort(CustomizedArray array) throws ArrayException;
    void selectionSort(CustomizedArray array) throws ArrayException;
}