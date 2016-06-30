package com.goit.ee.mod_1.providers.set;

import com.goit.ee.mod_1.api.Provider;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by Администратор on 26.03.2016.
 */
public class ProviderHashSet implements Provider<HashSet<Integer>> {

    @Override
    public HashSet<Integer> get(int size) {
        HashSet<Integer> result = new HashSet<>();

        for (int i = 0; i <= size; i++) {
            result.add(i);
        }
        return result;
    }
}
