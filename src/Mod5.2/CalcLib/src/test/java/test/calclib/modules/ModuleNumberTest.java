package test.calclib.modules;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.calclib.api.Module;
import test.calclib.exceptions.NotValidSizeArgumentsThisOperationType;
import test.calclib.operations.*;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

/**
 * Created by Chucky on 29.07.2016.
 */
public class ModuleNumberTest {

    Module instance = new ModuleNumber();

    private Map<String, Object> mapGood = new HashMap<>();
    private Map<String, Object> mapBed = new HashMap<>();

    @BeforeMethod
    void init() {

        instance.setOperation("+", new OperationNumberAdd());
        instance.setOperation("-", new OperationNumberSubtract());
        instance.setOperation("*", new OperationNumberMultiplication());
        instance.setOperation("/", new OperationNumberDivision());
        instance.setOperation("log", new OperationNumberLog());
        instance.setOperation("fact", new OperationNumberFactorial());
        instance.setOperation("sqrt", new OperationNumberSqrt());

        mapGood.put("right", "3");
        mapGood.put("left", "2");
        mapGood.put("operation", "+");

        mapBed.put("operation", "-");
        mapBed.put("right", "3");
    }

    @Test
    public void testExecute() throws Exception {
        assertEquals("5", instance.execute(mapGood));
    }

    @Test(expectedExceptions = NotValidSizeArgumentsThisOperationType.class)
    public void testExecuteExceptionNotValidSizeArgumentsThisOperationType() throws Exception {
        instance.execute(mapBed);
    }

    @Test(expectedExceptions = NotValidSizeArgumentsThisOperationType.class)
    public void testIsAbleExceptionNotValidSizeArgumentsThisOperationType() throws Exception {
        instance.isAble(mapBed);
    }

    @Test
    public void testIsAble() throws Exception {
        assertEquals(true, instance.isAble(mapGood));
    }

}