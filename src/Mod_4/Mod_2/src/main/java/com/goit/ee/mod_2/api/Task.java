package com.goit.ee.mod_2.api;

/**
 * Created by Администратор on 27.03.2016.
 */
public interface Task<T> {

    // Метода запускает таск на выполнение
    void execute();

    // Возвращает результат выполнения
    T getResult();


}