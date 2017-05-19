package com.demotodo.example.testng;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by bribin.zheng on 2017-05-19.
 */
@Listeners(MyHook.class)
public class HookTest {

    @Test
    public void test1() throws Exception {
        System.out.println("HookTest.test1");
    }

    @Test
    public void test2() throws Exception {
        System.out.println("HookTest.test2");
    }

    @Test
    public void skipTest() throws Exception {
        System.out.println("HookTest.skipTest");
    }

}
