package org.epam;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultDoubleTest {

    @DataProvider(name = "dataForTest")
    public Object[][] Data() {
        return new Object[][]{
                {1, 6, 6}, {10, 0, 0}, {3, -6, -18}, {1, 1.5, 1.5}, {1, -1.5, -1.5},
                {-5, 4, -20}, {-6, 0, 0}, {-4, -7, 28}, {-2, 1.5, -3}, {-2, -2.5, 5},
                {0, 87, 0}, {0, -76, 0}, {0, 0, 0}, {0, 1.5, 0}, {0, -1.5, 0}
        };
    }

    @BeforeMethod
    Calculator open() {
        return new Calculator();
    }

    @Test(dataProvider = "dataForTest",groups = "allTests")
    void test(double firstNumber, double secondNumber, double expectedResult) {
        Calculator calculator = open();
        double testMultDouble = calculator.mult(firstNumber, secondNumber);
        Assert.assertEquals(testMultDouble, expectedResult);
        //a defect (1 * 1.5 = 1.0 and 1 * -1.5 = -2.0) due to the Math.floor in the calculator
    }
}
