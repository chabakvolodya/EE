package com.goit.ee.mod_1.tests.list;

import com.goit.ee.mod_1.tests.TestTemplate;

import java.util.List;

/**
 * Created by Администратор on 26.03.2016.
 */
public class TestListPopulate extends TestTemplate<List<Integer>>{

    private int size;
    public TestListPopulate(List<Integer> collection, int iterations) {
        super(collection, iterations);
        size = collection.size();
    }

    @Override
    protected void body(int iteration) {
        collection.clear();

        for (int i = 0; i < size; i++) {
            collection.add(i, i);
        }
    }
}
