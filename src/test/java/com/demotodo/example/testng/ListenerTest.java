package com.demotodo.example.testng;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by bribin.zheng on 2017-05-19.
 */
@Listeners({MyTestListener.class, MyInvokedMethodListener.class})
public class ListenerTest {

    @Test
    public void test1() throws Exception {
        System.out.println("ListenerTest.test1");
    }

    @DisableListener
    @Test
    public void test2() throws Exception {
        System.out.println("ListenerTest.test2");
    }

}
