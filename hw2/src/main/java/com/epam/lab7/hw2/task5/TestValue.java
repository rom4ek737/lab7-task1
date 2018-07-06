package com.epam.lab7.hw2.task5;

import com.epam.lab7.hw2.task4.TestReflection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;

public class TestValue {
    static TestAnnotations annotations = new TestAnnotations();
    private static final Logger logger = LogManager.getLogger(TestReflection.class);

    public static void main(String[] args) throws Exception {
        TestValue testValue = new TestValue();
        String methodName = "";
        String path = "com.epam.lab7.hw2.task5.TestAnnotations";
        Class<?> cls = Class.forName(path);
        Class<?> cl = annotations.getClass();
        Object obj = cls.newInstance();
        Field field = cl.getDeclaredField("name");
        field.setAccessible(true);
        testValue.mySet("hello everybody");
        logger.info(annotations.getName());
    }

    public void mySet(int number) throws Exception {
        Class<?> cl = annotations.getClass();
        Field field = cl.getDeclaredField("name");
        field.setAccessible(true);
        field.setInt(annotations, number);
    }

    public void mySet(String str) throws Exception {
        Class<?> cl = annotations.getClass();
        Field field = cl.getDeclaredField("name");
        field.setAccessible(true);
        field.set(annotations, str);
    }

    public void mySet(boolean bool) throws Exception {
        Class<?> cl = annotations.getClass();
        Field field = cl.getDeclaredField("name");
        field.setAccessible(true);
        field.set(annotations, bool);
    }

    public void mySet(double number) throws Exception {
        Class<?> cl = annotations.getClass();
        Field field = cl.getDeclaredField("name");
        field.setAccessible(true);
        field.setDouble(annotations, number);
    }

    public void mySet(float number) throws Exception {
        Class<?> cl = annotations.getClass();
        Field field = cl.getDeclaredField("name");
        field.setAccessible(true);
        field.setFloat(annotations, number);
    }

    public void mySet(char ch) throws Exception {
        Class<?> cl = annotations.getClass();
        Field field = cl.getDeclaredField("name");
        field.setAccessible(true);
        field.setChar(annotations, ch);
    }

    public void mySet(long number) throws Exception {
        Class<?> cl = annotations.getClass();
        Field field = cl.getDeclaredField("name");
        field.setAccessible(true);
        field.setLong(annotations, number);
    }
}
