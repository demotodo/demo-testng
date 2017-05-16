package com.demotodo.example.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by bribin.zheng on 2017-05-15.
 */
public class DataProviderTest {

    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][]{
                {"Cedric", new Integer(36)},
                {"Anne", new Integer(37)},
        };
    }

    @Test(dataProvider = "test1")
    public void verifyData1(String n1, Integer n2) {
        System.out.println(n1 + " " + n2);
    }

    @Test(dataProvider = "create", dataProviderClass = StaticProvider.class)
    public void verifyData2(Integer n) {
        System.out.println(n);
    }

}
