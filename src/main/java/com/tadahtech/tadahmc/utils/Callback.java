package com.tadahtech.tadahmc.utils;

/**
 * Created by Timothy Andis (TadahTech)
 */
public class Callback<T> {
    private T t;
    public T get() {
        return t;
    }

    public void call(T t) {
        this.t = t;
    }
}
