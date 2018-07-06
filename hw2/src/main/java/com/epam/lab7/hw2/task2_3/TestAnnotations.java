package com.epam.lab7.hw2.task2_3;

public class TestAnnotations {

    private static int counter;
    @MyAnnotation(info = "Annotation field")
    private String name;
    @MyAnnotation
    private boolean var;

    TestAnnotations() {
        counter = 5;
        var = false;
    }

    TestAnnotations(String name) {
        this.name = name;
        counter = 0;
        var = true;
    }

    public void output() {
        String str = "Program is starting";
        TestAnnotations testAnnotations = new TestAnnotations();
        testAnnotations.doSomething();
        testAnnotations.doOther();
        TestAnnotations anno = new TestAnnotations("It is working");
        System.out.println(TestAnnotations.counter);
        System.out.println(anno.name);
    }

    public void doSomething() {
        System.out.println("Method doSomething is working");
    }

    public void doOther() {
        System.out.println("Method doOther is working");
        counter ++;
    }
}
