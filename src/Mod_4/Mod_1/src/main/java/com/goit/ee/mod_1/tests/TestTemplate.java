package com.goit.ee.mod_1.tests;

import com.goit.ee.mod_1.api.Test;

import java.util.Collection;

/**
 * Created by Администратор on 26.03.2016.
 */
public abstract class TestTemplate<T extends Collection> implements Test {

    private int iterations;
    protected T collection;


    public TestTemplate(T collection, int iterations) {
        this.collection = collection;
        this.iterations = iterations;
    }

    @Override
    public long run() {
        long result = 0L;

        for (int i = 0; i <= iterations; i++) {
            long startTime = System.nanoTime();
            body(i);
            long endTime = System.nanoTime();

            result += endTime - startTime;
        }

        return result / iterations;
    }

    protected abstract void body(int iteration);
}
