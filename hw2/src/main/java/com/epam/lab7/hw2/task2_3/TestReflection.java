package com.epam.lab7.hw2.task2_3;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class TestReflection {
    private static final Logger logger = LogManager.getLogger(TestReflection.class);
    Annotation[] annotations;
    static Class cls = TestAnnotations.class;
    public Annotation[] findFieldAnnotation(Class<?> clazz, String fieldName) {
        Annotation[] annotations = null;
        try {
            Field field = clazz.getDeclaredField(fieldName);
            if (field != null) {
                annotations = field.getAnnotations();
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return annotations;
    }

    public static void main(String[] args) throws NoSuchFieldException {
        Object object = TestAnnotations.class;
        String name = "name";
        String bool = "var";
        Annotation[] annotations;
        TestReflection ai = new TestReflection();

        String className = cls.getName();
        logger.info(className);
        logger.info(cls.getPackage());
        annotations = ai.findFieldAnnotation(TestAnnotations.class, name);
        logger.info("Annotation on field '" + name + "' are:");
        showAnnotations(annotations);

        annotations = ai.findFieldAnnotation(TestAnnotations.class, bool);
        logger.info("Annotation on field '" + bool + "' are:");
        showAnnotations(annotations);
        System.out.println(object);
        logger.info(object.toString());
    }

    public static void showAnnotations(Annotation[] ann) {
        if (ann == null)
            return;
        for (Annotation a : ann) {
            logger.info(a.toString());
        }
    }
    @Override
    public String toString() {
        return "@" + cls.getSimpleName() + cls.getAnnotation(MyAnnotation.class);
    }
}
