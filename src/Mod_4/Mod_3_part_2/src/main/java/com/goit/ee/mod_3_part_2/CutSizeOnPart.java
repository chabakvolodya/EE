package com.goit.ee.mod_3_part_2;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Chucky on 22.06.2016.
 */
public class CutSizeOnPart {

    private Deque<Integer> stack;
    private int value, part;

    public CutSizeOnPart(int value, int part) {
        this.value = value;
        this.part = part;
        stack = new ArrayDeque<>();
        cut();
    }

    public int getNextSize() {
        return stack.pollFirst();
    }

    private void cut() {

        int remainder = value % part;
        int sizePart = value / part;

        while (part-- > 0) {
            int addSize;

            if (remainder > 0) {
                addSize = sizePart + 1;
                remainder--;
            } else {
                addSize = sizePart;
            }

            stack.add(addSize);
        }
    }
}
