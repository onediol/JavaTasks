package com.task.array.entity;

import com.task.array.exceptions.ArrayException;

public class CustomizedArray {
    private final int[] array;

    public CustomizedArray(int[] array) {
        if (array == null) {
            this.array = new int[0];
        } else {
            this.array = new int[array.length];
            System.arraycopy(array, 0, this.array, 0, array.length);
        }
    }

    public int[] getArray() {
        int[] copy = new int[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        return copy;
    }

    public int getLength() {
        return array.length;
    }

    public int getElement(int index) throws ArrayException {
        if (index < 0 || index >= array.length) {
            throw new ArrayException("Index " + index + " out of bounds");
        }
        return array[index];
    }

    public CustomizedArray withElement(int index, int value) throws ArrayException {
        if (index < 0 || index >= array.length) {
            throw new ArrayException("Index " + index + " out of bounds");
        }

        int[] newArray = new int[array.length];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[index] = value;

        return new CustomizedArray(newArray);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CustomizedArray{");

        if (array == null || array.length == 0) {
            sb.append("[]");
        } else {
            sb.append('[');
            for (int i = 0; i < array.length; i++) {
                if (i > 0) sb.append(", ");
                sb.append(array[i]);
            }
            sb.append(']');
        }

        sb.append('}');
        return sb.toString();
    }
}