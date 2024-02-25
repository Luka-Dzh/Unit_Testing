package org.epam;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class isPositiveTest {

    @DataProvider(name = "dataForTest")
    public Object[][] Data() {
        return new Object[][]{
                {1L, true},
                {0L, false},
                {-1L, false},
                {-20L, false},
                {28L, true},
        };
    }

    @BeforeMethod
    Calculator open() {
        return new Calculator();
    }

    @Test(dataProvider = "dataForTest",groups = "allTests")
    void test(Long num, Boolean expectedResult) {
        Calculator calculator = open();
        Boolean testIsPositive = calculator.isPositive(num);
        Assert.assertEquals(testIsPositive, expectedResult);
    }
}
