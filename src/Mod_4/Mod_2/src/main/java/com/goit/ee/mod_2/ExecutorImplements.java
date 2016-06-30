package com.goit.ee.mod_2;

import com.goit.ee.mod_2.api.Executor;
import com.goit.ee.mod_2.api.Task;
import com.goit.ee.mod_2.api.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Chucky on 28.04.2016.
 */
public class ExecutorImplements<T> implements Executor<T> {

    private List<Task<? extends T>> taskQueue = new ArrayList<>();
    private HashMap<Task<? extends T>, Validator<T>> taskQueueValidator = new HashMap<>();
    private List<T> validResults = new ArrayList<>();
    private List<T> invalidResults = new ArrayList<>();

    @Override
    public void addTask(Task<? extends T> task) {
        taskQueue.add(task);
    }

    @Override
    public void addTask(Task<? extends T> task, Validator<T> validator) {
        taskQueueValidator.put(task, validator);
    }

    @Override
    public void execute() {
        for (Task<? extends T> task : taskQueue) {
                task.execute();
                validResults.add(task.getResult());
        }

        for (Task<? extends T> task : taskQueueValidator.keySet()) {

            task.execute();

            if (taskQueueValidator.get(task).isValid(task.getResult())) {
                validResults.add(task.getResult());
            } else {
                invalidResults.add(task.getResult());
            }
        }
    }

    @Override
    public List<T> getValidResults() {
        return validResults;
    }

    @Override
    public List<T> getInvalidResults() {
        return invalidResults;
    }
}
