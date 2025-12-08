package com.task.array.factory;

import com.task.array.entity.CustomizedArray;
import com.task.array.exceptions.ArrayException;

public interface ArrayFactory {
    CustomizedArray createArray(int[] values) throws ArrayException;
}