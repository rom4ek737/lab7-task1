package com.epam.lab7.hw2.task4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;

public class TestReflection {
    private static final Logger logger = LogManager.getLogger(TestReflection.class);

    public static void main(String[] args) throws Exception {
        String methodName = "";
        String path = "com.epam.lab7.hw2.task4.TestAnnotations";
        Class<?> cls = Class.forName(path);
        Object obj = cls.newInstance();

        methodName = "setName";
        Method setNameMethod = obj.getClass().getMethod(methodName, String.class);
        setNameMethod.invoke(obj, "Hello everybody");

        methodName = "getYear";
        Method getYearMethod = obj.getClass().getMethod(methodName);
        int year = (Integer) getYearMethod.invoke(obj);

        methodName = "output";
        Class<?>[] paramTypes = {String.class, int.class};
        Method printDogMethod = obj.getClass().getMethod(methodName, paramTypes);
        printDogMethod.invoke(obj, "Big boss", 2018);
    }
}
