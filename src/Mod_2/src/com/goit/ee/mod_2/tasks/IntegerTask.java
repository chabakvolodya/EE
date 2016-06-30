package com.goit.ee.mod_2.tasks;

import com.goit.ee.mod_2.api.Task;

/**
 * Created by Администратор on 27.04.2016.
 */
public class IntegerTask implements Task<Integer> {

    private Integer value;
    private Integer result;

    public IntegerTask(Integer value) {
        this.value = value;
    }

    @Override
    public void execute() {
        result = value;
    }

    @Override
    public Integer getResult() {
        return result;
    }
}
