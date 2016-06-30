package com.goit.ee.mod_1.testers;

import com.goit.ee.mod_1.api.Collector;
import com.goit.ee.mod_1.collectors.CollectionCollector;
import com.goit.ee.mod_1.tests.list.*;

import java.util.List;

/**
 * Created by Администратор on 26.03.2016.
 */
public class TesterList {

    private Collector<String, Long> collector;
    private List<Integer> collection;
    private int iterations;

    public TesterList(String name, List<Integer> collection, int iterations) {
        this.collector = new CollectionCollector(name);
        this.collection = collection;
        this.iterations = iterations;
        tests();
    }

    private void tests() {
        collector.collect("Add", new TestListAdd(collection, iterations).run());
        collector.collect("Get", new TestListGet(collection, iterations).run());
        collector.collect("Remove", new TestListRemove(collection, iterations).run());
        collector.collect("Contains", new TestListContains(collection, iterations).run());
        collector.collect("Populate", new TestListPopulate(collection, iterations).run());
        collector.collect("Iter.Add", new TestListIteratorAdd(collection, iterations).run());
        collector.collect("Iter.Rem", new TestListIteratorRemove(collection, iterations).run());

    }

    public Collector<String, Long> getCollector() {
        return collector;
    }
}
