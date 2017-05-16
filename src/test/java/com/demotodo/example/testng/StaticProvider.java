package com.demotodo.example.testng;

import org.testng.annotations.DataProvider;

/**
 * Created by bribin.zheng on 2017-05-15.
 */
public class StaticProvider {

    @DataProvider(name = "create")
    public static Object[][] createData() {
        return new Object[][]{
                new Object[]{new Integer(42)}
        };
    }

}
