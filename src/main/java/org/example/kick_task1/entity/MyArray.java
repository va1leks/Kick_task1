package org.example.kick_task1.entity;

import org.example.kick_task1.exception.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyArray {
    private int id;
    private static final Logger logger = LoggerFactory.getLogger(MyArray.class);
    private int[] array;

    public MyArray(int[] array) throws MyException{
        if (array == null) {
           throw new MyException("array is null");
        }
        this.array = array.clone();
        logger.info("Array created and initialized: {}",this.toString());
    }

    public MyArray(int length) throws MyException {
        if (length < 0) {
            logger.error("Invalid array length: {}",length);
            throw new MyException("Invalid array length");
        }
        array = new int[length];
        logger.info("Array created: {}",array.length);
    }

    public int getId() {
        logger.info("getId: {}",id);
        return id;
    }

    public void setId(int id) {
        this.id = id;
        logger.info("Set new id: {}",id);
    }

    public int[] getArray() {
        logger.info("getArray: {}",this.toString());
        return array.clone();
    }

    public void setArray(int[] array) {
        this.array = array.clone();
        logger.info("Set new array: {}",this.toString());
    }

    public int getLength() {
        logger.info("getLength: {}",array.length);
        return array.length;
    }

    public int get(int index) throws MyException {
        if (index < 0 || index >= array.length) {
            logger.error("Index out of bounds: {}",index);
            throw new MyException("Index out of bounds");
        }
        return array[index];
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            str.append(array[i]);
            str.append(" ");
        }
        return str.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof MyArray && ((MyArray) obj).getArray().length == array.length) {
            for (int i = 0; i < array.length; i++) {
                if(array[i] != ((MyArray) obj).getArray()[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        if(array.length == 0) return 0;

        int hash = 0;

        for (int i = 0; i < array.length; i++) {
            hash += array[i]*(i+1);
        }
        return hash;
    }
}
