package com.demotodo.example.testng;

import org.testng.annotations.Test;

/**
 * Created by bribin.zheng on 2017-05-18.
 */
public class GroupTest {

    @Test(groups = {"windows.checkintest"})
    public void testWindowsOnly() {
        System.out.println("GroupTest.testWindowsOnly");
    }

    @Test(groups = {"linux.checkintest", "broken"})
    public void testLinuxOnly() {
        System.out.println("GroupTest.testLinuxOnly");
    }

    @Test(groups = {"windows.functest"})
    public void testWindowsToo() {
        System.out.println("GroupTest.testWindowsToo");
    }

}
