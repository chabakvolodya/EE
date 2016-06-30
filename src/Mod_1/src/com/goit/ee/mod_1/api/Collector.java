package com.goit.ee.mod_1.api;

import java.util.Map;

/**
 * Created by Администратор on 26.03.2016.
 */
public interface Collector<K, V> {

    void collect(K namekey, V result);
    Map<K, V> getResults();
    String getNameCollector();
}
