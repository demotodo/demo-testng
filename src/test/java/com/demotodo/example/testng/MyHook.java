package com.demotodo.example.testng;

import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

/**
 * Created by bribin.zheng on 2017-05-19.
 */
public class MyHook implements IHookable {

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        boolean skip = testResult.getMethod().getConstructorOrMethod().getMethod()
                .getName().contains("skip");
        if (skip) {
            System.out.println("skip method: " + testResult);
        } else {
            callBack.runTestMethod(testResult);
        }
    }

}
