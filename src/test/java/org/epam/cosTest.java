package org.epam;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

public class cosTest {
    final double radians2Degrees = PI / 180;

    @DataProvider(name = "dataForTest")
    public Object[][] Data() {
        return new Object[][]{
                {0.0, 1.0},
                {radians2Degrees * 45, sqrt(2) / 2},
                {-45.0 * radians2Degrees, sqrt(2) / 2},
                {radians2Degrees * 90, 0.0},
                {-90 * radians2Degrees, 0.0},
                {135 * radians2Degrees, -sqrt(2) / 2}
        };
    }

    @BeforeMethod
    Calculator open() {
        return new Calculator();
    }

    @Test(dataProvider = "dataForTest", groups = "allTests")
    void test(double number, double expectedResult) {
        Calculator calculator = open();
        double testCos = calculator.cos(number);
        Assert.assertEquals(testCos, expectedResult, 0.01);//the defects everywhere except 45 due method calculates sin instead of cos
    }
}
