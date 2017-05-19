package com.demotodo.example.testng;

import org.testng.IAnnotationTransformer2;
import org.testng.annotations.IConfigurationAnnotation;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.ITestAnnotation;
import org.testng.log4testng.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by bribin.zheng on 2017-05-19.
 */
public class MyAnnotationTransformer implements IAnnotationTransformer2 {

    private Logger logger = Logger.getLogger(MyAnnotationTransformer.class);

    @Override
    public void transform(IConfigurationAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        logger.info("IConfigurationAnnotation: " + annotation);
        // System.out.println("IConfigurationAnnotation: " + annotation);
    }

    @Override
    public void transform(IDataProviderAnnotation annotation, Method method) {
        logger.info("IDataProviderAnnotation: " + annotation);
        // System.out.println("IDataProviderAnnotation: " + annotation);
    }

    @Override
    public void transform(IFactoryAnnotation annotation, Method method) {
        logger.info("IFactoryAnnotation: " + annotation);
        // System.out.println("IFactoryAnnotation: " + annotation);
    }

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        logger.info("ITestAnnotation: " + annotation);
        // System.out.println("ITestAnnotation: " + annotation);
    }

}
