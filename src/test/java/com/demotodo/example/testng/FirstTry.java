package com.demotodo.example.testng;

import org.testng.annotations.*;

/**
 * Created by bribin.zheng on 2017-05-12.
 */
public class FirstTry {

    @BeforeClass
    public void init() {
        System.out.println("before class");
    }


    @BeforeMethod
    public void beforeM() {
        System.out.println("before method");
    }

    @Test
    public void test1() {
        System.out.println("test 1");
    }

    @Test
    public void test2() {
        System.out.println("test 2");
    }

    @AfterMethod
    public void afterM() {
        System.out.println("after method");
    }

    @AfterClass
    public void destroy() {
        System.out.println("after class");
    }

}
