package com.goit.ee.mod_1.tests.set;

import com.goit.ee.mod_1.tests.TestTemplate;

import java.util.Set;

/**
 * Created by Администратор on 26.03.2016.
 */
public class TestSetAdd extends TestTemplate<Set<Integer>>{

    private int startIndex;

    public TestSetAdd(Set<Integer> collection, int iterations) {
        super(collection, iterations);
        startIndex = collection.size() - 1;
    }

    @Override
    protected void body(int iteration) {
        collection.add(startIndex + iteration);
    }
}
