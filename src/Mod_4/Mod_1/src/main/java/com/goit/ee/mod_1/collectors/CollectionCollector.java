package com.goit.ee.mod_1.collectors;

import com.goit.ee.mod_1.api.Collector;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Администратор on 26.03.2016.
 */
public class CollectionCollector implements Collector<String, Long> {

    private Map<String, Long> results;
    private String name;

    public CollectionCollector(String name) {
        this.name = name;
        results = new HashMap<>();
    }

    @Override
    public void collect(String nameKey, Long result) {
        results.put(nameKey, result);
    }

    @Override
    public Map<String, Long> getResults() {
        return results;
    }

    @Override
    public String getNameCollector() {
        return name;
    }
}
