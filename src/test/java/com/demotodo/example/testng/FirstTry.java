package com.demotodo.example.testng;

import org.testng.annotations.*;

/**
 * Created by bribin.zheng on 2017-05-12.
 */
public class FirstTry {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("FirstTry.beforeSuite");
    }

    @BeforeGroups("group1")
    public void beforeGroups() {
        System.out.println("FirstTry.beforeGroups");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("FirstTry.beforeTest");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("FirstTry.beforeClass");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("FirstTry.beforeMethod");
    }

    @Test(groups = "group1")
    public void test1() {
        System.out.println("FirstTry.test1");
    }

    @Test(groups = "group2")
    public void test2() {
        System.out.println("FirstTry.test2");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("FirstTry.afterMethod");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("FirstTry.afterClass");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("FirstTry.afterTest");
    }

    @AfterGroups
    public void afterGroups() {
        System.out.println("FirstTry.afterGroups");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("FirstTry.afterSuite");
    }

}
