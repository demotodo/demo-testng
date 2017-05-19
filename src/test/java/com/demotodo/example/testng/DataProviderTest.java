package com.demotodo.example.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by bribin.zheng on 2017-05-15.
 */
public class DataProviderTest {

    private int index = 0;

    public DataProviderTest() {
    }

    public DataProviderTest(int index) {
        this.index = index;
    }

    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][]{
                {"Cedric", new Integer(36)},
                {"Anne", new Integer(37)},
        };
    }

    @Test(dataProvider = "test1")
    public void verifyData1(String n1, Integer n2) {
        System.out.println(index + "-verifyData1: " + n1 + " " + n2);
    }

    @Test(dataProvider = "create", dataProviderClass = StaticProvider.class)
    public void verifyData2(Integer n) {
        System.out.println(index + "-DataProviderTest.verifyData2: " + n);
    }

    //
    @DataProvider(name = "test2")
    public Iterator<Object[]> createData2() {
        return Arrays.asList(new Object[]{"Cedric2", 36}, new Object[]{"Anne2", 37})
                .iterator();
    }

    @Test(dataProvider = "test2")
    public void verifyData2(String n1, Integer n2) {
        System.out.println(index + "-verifyData2: " + n1 + " " + n2);
    }

}
