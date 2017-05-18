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

    // If 'value' or 'groups' is not specified, then won't be run, even 'alwaysRun' is set to true.
    @BeforeGroups(alwaysRun = true)
    public void beforeGroupsNotSpecified() {
        System.out.println("FirstTry.beforeGroupsNotSpecified");
    }

    @BeforeGroups("group1")
    public void beforeGroups() {
        System.out.println("FirstTry.beforeGroups-group1");
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

    @Test(groups = {"group1", "group3"})
    public void test1() {
        System.out.println("FirstTry.test1-group1-group3");
    }

    @Test(groups = "group2")
    public void test2() {
        System.out.println("FirstTry.test2-group2");
    }

    @Test(groups = "group1")
    public void test3() {
        System.out.println("FirstTry.test3-group1");
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

    @AfterGroups("group1")
    public void afterGroups() {
        System.out.println("FirstTry.afterGroups-group1");
    }

    @AfterGroups
    public void afterGroupsNotSpecified() {
        System.out.println("FirstTry.afterGroupsNotSpecified");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("FirstTry.afterSuite");
    }

}
