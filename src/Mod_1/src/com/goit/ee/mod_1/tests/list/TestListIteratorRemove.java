package com.goit.ee.mod_1.tests.list;

import com.goit.ee.mod_1.tests.TestTemplate;

import java.util.List;
import java.util.ListIterator;

/**
 * Created by Администратор on 26.03.2016.
 */
public class TestListIteratorRemove extends TestTemplate<List<Integer>> {

    private ListIterator<Integer> iterator;

    public TestListIteratorRemove(List<Integer> collection, int iterations) {
        super(collection, iterations);
        iterator = collection.listIterator();
    }

    @Override
    protected void body(int iteration) {
        if (iterator.hasNext()){
            iterator.next();
            iterator.remove();
        }
    }
}
