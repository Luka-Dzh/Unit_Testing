package org.epam;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Math.sqrt;

public class powTest {

    @DataProvider(name = "dataForTest")
    public Object[][] Data() {
        return new Object[][]{
                {1, 6, 1}, {10, 0, 1}, {3, -1, (double) 1 / 3}, {2, 1.5,(double) 2* sqrt(2)}, {2, -1.5, sqrt(2)/4},
                {-5, 2, 25}, {-6, 0, 1}, {-4, -2, (double) 1 / 16}, {-1, 1.5, -1}, {-1, -2.5, -1},
                {0, 87, 0}, {0, -76, 0}, {0, 0, 1}, {0, 1.5, 0}, {0, -1.5, 0}
        };
    }

    @BeforeMethod
    Calculator open() {
        return new Calculator();
    }

    @Test(dataProvider = "dataForTest", groups = "allTests")
    void test(double firstNumber, double secondNumber, double expectedResult) {
        Calculator calculator = open();
        Double testPow = calculator.pow(firstNumber, secondNumber);//a defect, when zero powered into negative number: 0^(-76)=infinity
        Assert.assertEquals(testPow, expectedResult);//a defect when powering number is floating due to the flooring of power
    }
}
