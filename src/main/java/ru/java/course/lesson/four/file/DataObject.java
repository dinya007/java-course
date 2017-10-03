package ru.java.course.lesson.four.file;

import java.io.Serializable;

/**
 * @author dinyat
 * 03/10/2017
 */
public class DataObject implements Serializable {

    private String data;

    public DataObject() {
    }

    public DataObject(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataObject{" +
            "data='" + data + '\'' +
            '}';
    }
}
