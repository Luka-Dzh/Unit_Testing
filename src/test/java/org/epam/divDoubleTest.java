package org.epam;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class divDoubleTest {

    @DataProvider(name = "dataForTest")
    public Object[][] Data() {
        return new Object[][]{
                {1, 6, (double) 1 / 6}, {10, 0, NumberFormatException.class}, {3, -6, (double) -1 / 2}, {1, 1.5, (double) 1 / 1.5}, {1, -1.5, (double) -2 / 3},
                {-4, 4, -1d}, {-6, 0, NumberFormatException.class}, {-4, -40, 0.1}, {-2, 1.5, (double) -4 / 3}, {-2, -2.5, (double) 4 / 5},
                {0, 87, 0d}, {0, -76, 0d}, {0, 0, NumberFormatException.class}, {0, 1.5, 0d}, {0, -1.5, 0d}
        };
    }

    @BeforeMethod
    Calculator open() {
        return new Calculator();
    }

    @Test(dataProvider = "dataForTest", groups = "allTests")
    void test(double firstNumber, double secondNumber, Object expectedResult) {
        try {
            Calculator calculator = open();
            Double testDivDouble = calculator.div(firstNumber, secondNumber);
            Assert.assertEquals(testDivDouble, expectedResult);//a defect when dividing zero by negative will lead to -0.0 instead of 0.0
        } catch (NumberFormatException e) {
            Assert.assertEquals(e.getClass(), expectedResult);//a defect due to the lack of throwing the exception in cases when dividing by zero
        }
    }
}
