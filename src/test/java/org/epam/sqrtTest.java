package org.epam;

import com.beust.ah.A;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Math.sqrt;

public class sqrtTest {

    @DataProvider(name = "dataForTest")
    public Object[][] Data() {
        return new Object[][]{
                {1.0, 1.0}, {0.0, 0.0}, {-3, NumberFormatException.class}, {1.5, sqrt(1.5)}, {-1.5, NumberFormatException.class}
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
            Double testSqrt = calculator.sqrt(number);
            Assert.assertEquals(testSqrt, expectedResult);
        }catch (NumberFormatException e){
            Assert.assertEquals(e.getClass(),expectedResult);//a defect due Math.abs instead of throwing an exception for negative values
        }
    }
}
