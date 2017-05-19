package com.demotodo.example.testng;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener2;
import org.testng.ITestContext;
import org.testng.ITestResult;

/**
 * Created by bribin.zheng on 2017-05-19.
 */
public class MyInvokedMethodListener implements IInvokedMethodListener2 {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        DisableListener annotation = method.getTestMethod().getConstructorOrMethod().getMethod()
                .getAnnotation(DisableListener.class);
        if (annotation != null) {
            System.out.println("annotated @DisableListener: " + method);
            return;
        }
        System.out.println("no annotated @DisableListener: " + method);
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {

    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

    }

}
