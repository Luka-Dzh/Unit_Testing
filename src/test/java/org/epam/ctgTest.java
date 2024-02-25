package org.epam;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ctgTest {

    @DataProvider(name = "dataForTest")
    public Object[][] Data() {
        return new Object[][]{
                {0.0, NumberFormatException.class},
                {45, 1.0},
                {-45.0, -1.0},
                {90, 0.0},
                {-90, 0.0},
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
            double testCtg = calculator.ctg(number);
            Assert.assertEquals(testCtg, expectedResult);//a defect ctg(90)=1, ctg(-90)=-1 instead of being 0 both
        } catch (NumberFormatException e) {
            Assert.assertEquals(e.getClass(), expectedResult);//a defect tg(0)=0 instead of throwing the exception
        }
    }
}
