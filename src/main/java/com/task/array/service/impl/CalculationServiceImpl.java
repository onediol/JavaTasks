package com.task.array.service.impl;

import com.task.array.entity.CustomizedArray;
import com.task.array.exceptions.ArrayException;
import com.task.array.service.CalculationService;

public class CalculationServiceImpl implements CalculationService {
    @Override
    public double findMaxElement(CustomizedArray array) throws ArrayException {
        if (array == null || array.getLength() == 0) {
            throw new ArrayException("Array is empty");
        }

        int[] elements = array.getArray();
        int max = elements[0];

        for (int i = 1; i < elements.length; i++) {
            if (elements[i] > max) {
                max = elements[i];
            }
        }

        return max;
    }

    @Override
    public double findMinElement(CustomizedArray array) throws ArrayException {
        if (array == null || array.getLength() == 0) {
            throw new ArrayException("Array is empty");
        }

        int[] elements = array.getArray();
        int min = elements[0];

        for (int i = 1; i < elements.length; i++) {
            if (elements[i] < min) {
                min = elements[i];
            }
        }

        return min;
    }

    @Override
    public double sumElements(CustomizedArray array) throws ArrayException {
        if (array == null) {
            throw new ArrayException("Array is null");
        }

        int[] elements = array.getArray();
        int sum = 0;

        for (int element : elements) {
            sum += element;
        }

        return sum;
    }
}