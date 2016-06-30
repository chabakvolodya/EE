package com.goit.ee.mod_1.providers.list;

import com.goit.ee.mod_1.api.Provider;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Администратор on 26.03.2016.
 */
public class ProviderLinkedList implements Provider<LinkedList<Integer>> {

    @Override
    public LinkedList<Integer> get(int size) {
        LinkedList<Integer> result = new LinkedList<>();

        for (int i = 0; i <= size; i++) {
            result.add(i);
        }
        return result;
    }
}
