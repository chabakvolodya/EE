package com.goit.ee.mod_1.tests.set;

import com.goit.ee.mod_1.tests.TestTemplate;

import java.util.Set;

/**
 * Created by Администратор on 26.03.2016.
 */
public class TestSetPopulate extends TestTemplate<Set<Integer>> {

    private int size;

    public TestSetPopulate(Set<Integer> collection, int iterations) {
        super(collection, iterations);
        size = collection.size();
    }

    @Override
    protected void body(int iteration) {
        collection.clear();

        for (int i = 0; i < size; i++) {
            collection.add(i);
        }
    }
}
