package com.demotodo.example.testng;

import org.testng.annotations.Test;

/**
 * Created by bribin.zheng on 2017-05-19.
 */
public class DependencyTest {

    @Test(dependsOnMethods = "method2")
    public void method1() throws Exception {
        System.out.println("DependencyTest.method1");
    }

    @Test(dependsOnGroups = "g1")
    public void method2() throws Exception {
        System.out.println("DependencyTest.method2");
    }

    @Test(groups = "g1", dependsOnGroups = "g2")
    public void group1Method1() throws Exception {
        System.out.println("DependencyTest.group1Method1");
    }

    @Test(groups = "g2")
    public void group1Method2() throws Exception {
        System.out.println("DependencyTest.group1Method2");
    }

}
