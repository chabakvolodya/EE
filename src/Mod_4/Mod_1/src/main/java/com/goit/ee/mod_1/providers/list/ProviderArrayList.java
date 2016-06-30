package com.goit.ee.mod_1.providers.list;

import com.goit.ee.mod_1.api.Provider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 26.03.2016.
 */
public class ProviderArrayList implements Provider<ArrayList<Integer>> {

    @Override
    public ArrayList<Integer> get(int size) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i <= size; i++) {
            result.add(i);
        }
        return result;
    }
}
