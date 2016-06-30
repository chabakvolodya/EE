package com.goit.ee.mod_1.tests.set;

import com.goit.ee.mod_1.tests.TestTemplate;

import java.util.Set;

/**
 * Created by Администратор on 26.03.2016.
 */
public class TestSetRemove extends TestTemplate<Set<Integer>> {

    public TestSetRemove(Set<Integer> collection, int iterations) {
        super(collection, iterations);
    }

    @Override
    protected void body(int iteration) {
        int value = (int)Math.round(Math.random() * collection.size());
        collection.remove(value);
    }
}
