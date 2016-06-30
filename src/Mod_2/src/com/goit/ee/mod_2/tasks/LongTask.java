package com.goit.ee.mod_2.tasks;

import com.goit.ee.mod_2.api.Task;

/**
 * Created by Администратор on 27.04.2016.
 */
public class LongTask implements Task<Long> {

    private Long value;
    private Long result;

    public LongTask(Long value) {
        this.value = value;
    }

    @Override
    public void execute() {
        result = value;
    }

    @Override
    public Long getResult() {
        return result;
    }
}
