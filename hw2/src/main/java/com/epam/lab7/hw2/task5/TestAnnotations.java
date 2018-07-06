package com.epam.lab7.hw2.task5;

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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
