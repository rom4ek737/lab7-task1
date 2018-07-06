package com.epam.lab7.hw2.task4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestAnnotations {
    private static final Logger logger = LogManager.getLogger(TestReflection.class);
    private static int counter;
    @MyAnnotation(info = "Annotation field")
    private String name;
    @MyAnnotation
    private boolean var;
    private int year;

    TestAnnotations() {
        counter = 5;
        var = false;
    }

    TestAnnotations(String name) {
        this.name = name;
        counter = 0;
        var = true;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void output(String s, int number) {
        String str = "Program is starting";
        TestAnnotations testAnnotations = new TestAnnotations();
        testAnnotations.doSomething(5);
        testAnnotations.doOther(true);
        TestAnnotations anno = new TestAnnotations("It is working");
        logger.info(TestAnnotations.counter);
        logger.info(anno.name);
        logger.info("Name = " + s + ", year = " + number);
        logger.info(name);
//        return str + anno;
    }

    public int doSomething(int number) {
        logger.info("Method doSomething is working " + number);
        return  number + 5;
    }

    public boolean doOther(boolean bool) {
        logger.info("Method doOther is working " + bool);
        counter ++;
        return false;
    }
}
