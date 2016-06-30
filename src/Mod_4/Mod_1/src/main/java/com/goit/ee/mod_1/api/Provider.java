package com.goit.ee.mod_1.api;

/**
 * Created by Администратор on 26.03.2016.
 */
public interface Provider<T> {
    T get(int size);
}
