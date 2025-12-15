package com.task.array.factory;

import com.task.array.entity.CustomizedArray;
import com.task.array.exception.ArrayException;

public interface ArrayFactory {
    CustomizedArray createArray(int[] values) throws ArrayException;
}