package com.task.array.entity;

import com.task.array.exception.ArrayException;
import com.task.array.observer.ArrayObservable;
import com.task.array.observer.ArrayObserver;
import com.task.array.util.IdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomizedArray implements ArrayObservable {

    private static final Logger logger = LogManager.getLogger();

    private final int id;
    private int[] array;

    private final List<ArrayObserver> observers = new ArrayList<>();

    public CustomizedArray(int[] array) {
        this.id = IdGenerator.generateId();
        this.array = array != null ? array.clone() : new int[0];
    }

    @Override
    public void attach(ArrayObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(ArrayObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (ArrayObserver observer : observers) {
            observer.changePerformed(this);
        }
    }

    public int getId() {
        return id;
    }

    public int[] getArray() {
        return array.clone();
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

    public void setElement(int index, int value) throws ArrayException {
        if (index < 0 || index >= array.length) {
            throw new ArrayException("Index " + index + " out of bounds");
        }

        array[index] = value;
        logger.info("Element at index {} changed to {}. Notifying observers...", index, value);
        notifyObservers();
    }

    public void setArray(int[] newArray) {
        this.array = newArray != null ? newArray.clone() : new int[0];
        logger.info("Array replaced. Notifying observers...");
        notifyObservers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomizedArray that = (CustomizedArray) o;
        return id == that.id && Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(id);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    @Override
    public String toString() {
        return "CustomizedArray{" +
                "id=" + id +
                ", array=" + Arrays.toString(array) +
                '}';
    }
}
