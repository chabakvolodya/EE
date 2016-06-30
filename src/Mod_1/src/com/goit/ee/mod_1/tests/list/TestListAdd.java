package com.goit.ee.mod_1.tests.list;

import com.goit.ee.mod_1.tests.TestTemplate;

import java.util.List;

/**
 * Created by Администратор on 26.03.2016.
 */
public class TestListAdd extends TestTemplate<List<Integer>> {

    public TestListAdd(List<Integer> collection, int iterations) {
        super(collection, iterations);
    }

    @Override
    protected void body(int iteration) {
        int index = (int)Math.round(Math.random() * collection.size());
        collection.add(index, iteration);
    }
}
