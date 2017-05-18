package com.demotodo.example.testng;

import org.testng.annotations.Test;

/**
 * Created by bribin.zheng on 2017-05-18.
 */
@Test(groups = {"checkintest"})
public class PartialGroupTest {

    public void testWindowsOnly() {
        System.out.println("GroupTest.testWindowsOnly");
    }

    public void testLinuxOnly() {
        System.out.println("GroupTest.testLinuxOnly");
    }

    @Test(groups = {"functest"})
    public void testWindowsToo() {
        System.out.println("GroupTest.testWindowsToo");
    }

}
