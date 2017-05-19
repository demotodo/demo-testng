package com.demotodo.example.testng;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.xml.XmlTest;

import java.lang.reflect.Method;

/**
 * Created by bribin.zheng on 2017-05-19.
 */
public class InectionTest {

    @BeforeTest
    public void beforeTest(XmlTest xmlTest) {
        System.out.println("xmlTest = [" + xmlTest + "]");
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        System.out.println("method = [" + method + "]");
    }

    @Test
    public void testInjection(ITestContext context) throws Exception {
        System.out.println("InectionTest.testInjection: " + context);
    }

    @Test
    public void testNoInjection(@NoInjection ITestContext context) throws Exception {
        System.out.println("InectionTest.testNoInjection: " + context);
    }

    @AfterMethod
    public void showTestResult(ITestResult testResult) {
        System.out.println("testResult = [" + testResult + "]");
    }

}
