package org.epam;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class isNegativeTest {

    @DataProvider(name = "dataForTest")
    public Object[][] Data() {
        return new Object[][]{
                {1L, false},
                {0L, false},
                {-1L, true},
                {-20L, true},
                {28L, false},
        };
    }

    @BeforeMethod
    Calculator open() {
        return new Calculator();
    }

    @Test(dataProvider = "dataForTest", groups = "allTests")
    void test(Long num, Boolean expectedResult) {
        Calculator calculator = open();
        Boolean testIsNegative = calculator.isNegative(num);
        Assert.assertEquals(testIsNegative, expectedResult);
    }
}
