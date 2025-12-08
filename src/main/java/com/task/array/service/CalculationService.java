package com.task.array.service;

import com.task.array.entity.CustomizedArray;
import com.task.array.exceptions.ArrayException;

public interface CalculationService {
    double findMaxElement(CustomizedArray array) throws ArrayException;
    double findMinElement(CustomizedArray array) throws ArrayException;
    double sumElements(CustomizedArray array) throws ArrayException;
}