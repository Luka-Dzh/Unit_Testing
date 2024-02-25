package org.epam;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubTest {

    @DataProvider(name = "dataForTest")
    public Object[][] Data() {
        return new Object[][]{
                {1L, 6L, -5L}, {10L, 0L, 10L}, {34L, -6L, 40L},
                {-5L, 4L, -9L}, {-6L, 0L, -6L}, {-4L, -7L, 3L},
                {0L, 87L, -87L}, {0L, -76L, 76L}, {0L, 0L, 0L}
        };
    }

    @BeforeMethod
    Calculator open() {
        return new Calculator();
    }

    @Test(dataProvider = "dataForTest", groups = "allTests")
    void test(Long firstNumber, Long secondNumber, Long expectedResult) {
        Calculator calculator = open();
        Long testSub = calculator.sub(firstNumber, secondNumber);
        Assert.assertEquals(testSub, expectedResult);
    }
}
