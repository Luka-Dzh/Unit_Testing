package org.epam;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubDoubleTest {

    @DataProvider(name = "dataForTest")
    public Object[][] Data() {
        return new Object[][]{
                {1, 6, -5}, {10, 0, 10}, {34, -6, 40}, {1, 1.5, -0.5}, {1, -1.5, 2.5},
                {-5, 4, -9}, {-6, 0, -6}, {-4, -7, 3}, {-2, 1.5, -3.5}, {-2, -2.5, 0.5},
                {0, 87, -87}, {0, -76, 76}, {0, 0, 0}, {0, 1.5, -1.5}, {0, -1.5, 1.5}
        };
    }

    @BeforeMethod
    Calculator open() {
        return new Calculator();
    }

    @Test(dataProvider = "dataForTest", groups = "allTests")
    void test(double firstNumber, double secondNumber, double expectedResult) {
        Calculator calculator = open();
        Double testSubDouble = calculator.sub(firstNumber, secondNumber);
        Assert.assertEquals(testSubDouble, expectedResult);
    }
}
