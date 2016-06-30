package com.goit.ee.mod_2.validator;

import com.goit.ee.mod_2.api.Validator;

/**
 * Created by Администратор on 24.04.2016.
 */
public class NumberValidator implements Validator<Number> {


    @Override
    public boolean isValid(Number result) {

        double value = result.doubleValue();
        return  value >= 5 && value <= 10;
    }
}
