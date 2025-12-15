package com.task.array.service.impl;

import com.task.array.entity.CustomizedArray;
import com.task.array.exception.ArrayException;
import com.task.array.service.SortService;

public class SortServiceImpl implements SortService {

    @Override
    public void bubbleSort(CustomizedArray array) throws ArrayException {
        int[] elements = array.getArray();
        int n = elements.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (elements[j] > elements[j + 1]) {
                    int temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < elements.length; i++) {
            array.setElement(i, elements[i]);
        }
    }

    @Override
    public void selectionSort(CustomizedArray array) throws ArrayException {
        int[] elements = array.getArray();
        int n = elements.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (elements[j] < elements[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = elements[minIndex];
                elements[minIndex] = elements[i];
                elements[i] = temp;
            }
        }

        for (int i = 0; i < elements.length; i++) {
            array.setElement(i, elements[i]);
        }
    }
}
