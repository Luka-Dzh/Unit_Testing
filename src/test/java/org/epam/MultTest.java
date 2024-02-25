package org.epam;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultTest {

    @DataProvider(name = "dataForTest")
    public Object[][] Data() {
        return new Object[][]{
                {1L, 6L, 6L}, {10L, 0L, 0L}, {3L, -6L, -18L},
                {-5L, 4L, -20L}, {-6L, 0L, 0L}, {-4L, -7L, 28L},
                {0L, 87L, 0L}, {0L, -76L, 0L}, {0L, 0L, 0L}
        };
    }

    @BeforeMethod
    Calculator open() {
        return new Calculator();
    }

    @Test(dataProvider = "dataForTest", groups = "allTests")
    void test(Long firstNumber, Long secondNumber, Long expectedResult) {
        Calculator calculator = open();
        Long testMult = calculator.mult(firstNumber, secondNumber);
        Assert.assertEquals(testMult, expectedResult);
    }
}
