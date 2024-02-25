package org.epam;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Math.PI;

public class tgTest {
    final double radians2Degrees = PI / 180;

    @DataProvider(name = "dataForTest")
    public Object[][] Data() {
        return new Object[][]{
                {0.0, 0.0},
                {radians2Degrees * 45, 1.0},
                {-45.0 * radians2Degrees, -1.0},
                {radians2Degrees * 90, NumberFormatException.class},
                {-90 * radians2Degrees, NumberFormatException.class},
        };
    }

    @BeforeMethod
    Calculator open() {
        return new Calculator();
    }

    @Test(dataProvider = "dataForTest", groups = "allTests")
    void test(double number, Object expectedResult) {
        try {
            Calculator calculator = open();
            double testTg = calculator.tg(number);
            Assert.assertEquals(testTg, expectedResult);//a defect tg(0)=NaN instead of 0, a defect tg(-45)=1 instead of -1
        } catch (NumberFormatException e) {
            Assert.assertEquals(e.getClass(), expectedResult);//a defect tg(90)=1,tg(-90)=1 instead of throwing the exception
        }
    }
}
