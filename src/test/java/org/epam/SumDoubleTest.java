package org.epam;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumDoubleTest {

    @DataProvider(name = "dataForTest")
    public Object[][] Data() {
        return new Object[][]{
                {1, 6, 7}, {10, 0, 10}, {34, -6, 28}, {1, 1.5, 2.5}, {1, -1.5, -0.5},
                {-5, 4, -1}, {-6, 0, -6}, {-4, -7, -11}, {-2, 1.5, -0.5}, {-2, -2.5, -4.5},
                {0, 87, 87}, {0, -76, -76}, {0, 0, 0}, {0, 1.5, 1.5}, {0, -1.5, -1.5}
        };
    }

    @BeforeMethod
    Calculator open() {
        return new Calculator();
    }

    @Test(dataProvider = "dataForTest", groups = "allTests")
    void test(double firstNumber, double secondNumber, double expectedResult) {
        Calculator calculator = open();
        double testSumDouble = calculator.sum(firstNumber, secondNumber);
        Assert.assertEquals(testSumDouble, expectedResult);
    }
}
