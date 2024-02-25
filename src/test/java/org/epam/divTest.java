package org.epam;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class divTest {

    @DataProvider(name = "dataForTest")
    public Object[][] Data() {
        return new Object[][]{
                {6L, 1L, 6L}, {10L, 0L, NumberFormatException.class}, {36L, -6L, -6L},
                {-4L, 4L, -1L}, {-6L, 0L, NumberFormatException.class}, {-8L, -4L, 2L},
                {0L, 87L, 0L}, {0L, -76L, 0L}, {0L, 0L, NumberFormatException.class}
        };
    }

    @BeforeMethod
    Calculator open() {
        return new Calculator();
    }

    @Test(dataProvider = "dataForTest", groups = "allTests")
    void test(Long firstNumber, Long secondNumber, Object expectedResult) {
        try {
            Calculator calculator = open();
            Long testDiv = calculator.div(firstNumber, secondNumber);
            Assert.assertEquals(testDiv, expectedResult);
        }catch (NumberFormatException e){                           //catching exceptions in cases when dividing by zero
            Assert.assertEquals(e.getClass(),expectedResult);
        }
    }
}
