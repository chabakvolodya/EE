package com.goit.ee.mod_1.providers.set;

import com.goit.ee.mod_1.api.Provider;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by Администратор on 26.03.2016.
 */
public class ProviderTreeSet implements Provider<TreeSet<Integer>> {

    @Override
    public TreeSet<Integer> get(int size) {
        TreeSet<Integer> result = new TreeSet<>();

        for (int i = 0; i <= size; i++) {
            result.add(i);
        }
        return result;
    }
}
