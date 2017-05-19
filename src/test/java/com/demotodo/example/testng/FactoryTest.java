package com.demotodo.example.testng;

import org.testng.annotations.Factory;

/**
 * Created by bribin.zheng on 2017-05-19.
 */
public class FactoryTest {

    @Factory
    public Object[] createInstances() {
        Object[] result = new Object[10];
        for (int i = 0; i < 10; i++) {
            result[i] = new DependencyTest();
        }
        return result;
    }

}
