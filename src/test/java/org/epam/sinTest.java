package org.epam;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

public class sinTest {
    final double radians2Degrees = PI / 180;

    @DataProvider(name = "dataForTest")
    public Object[][] Data() {
        return new Object[][]{
                {0.0, 0.0}, {radians2Degrees * 45, sqrt(2) / 2}, {-45.0 * radians2Degrees, -sqrt(2) / 2},
                {radians2Degrees * 90, 1.0}, {-90 * radians2Degrees, -1.0}, {135 * radians2Degrees, sqrt(2) / 2}
        };
    }

    @BeforeMethod
    Calculator open() {
        return new Calculator();
    }

    @Test(dataProvider = "dataForTest",groups = "allTests")
    void test(double number, double expectedResult) {
        Calculator calculator = open();
        double testSin = calculator.sin(number);
        Assert.assertEquals(testSin, expectedResult, 0.01);
    }
}
