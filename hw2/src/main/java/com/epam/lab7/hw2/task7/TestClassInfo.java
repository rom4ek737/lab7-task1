package com.epam.lab7.hw2.task7;

import com.epam.lab7.hw2.task4.TestReflection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TestClassInfo {
    private static final Logger logger = LogManager.getLogger(TestReflection.class);

    public static void main(String[] args) throws Exception {
        String path = "com.epam.lab7.hw2.task4.TestAnnotations";
        Class<?> cls = Class.forName(path);
        getFields(cls);
        getConstruktors(cls);
        getMethods(cls);
    }

    public static Collection<Field> getFields(Class<?> clss) throws Exception {
        Map<String, Field> fields = new HashMap<String, Field>();
        while (clss != null) {
            for (Field field : clss.getDeclaredFields()) {
                if (!fields.containsKey(field.getName())) {
                    fields.put(field.getName(), field);
                    logger.info(field);
                }
            }
            clss = clss.getSuperclass();
        }
        Collection<Field> returnCollection = fields.values();
        return returnCollection;
    }

    public static Collection<Constructor> getConstruktors(Class<?> clss) throws Exception {
        Map<String, Constructor> cons = new HashMap<>();
        while (clss != null) {
            for (Constructor con : clss.getDeclaredConstructors()) {
                if (!cons.containsKey(con.getName())) {
                    cons.put(con.getName(), con);
                    logger.info(con);
                }
            }

            clss = clss.getSuperclass();
        }
        Collection<Constructor> returnCollection = cons.values();
        return returnCollection;
    }

    public static Collection<Method> getMethods(Class<?> clss) throws Exception {
        Map<String, Method> mets = new HashMap<>();
        while (clss != null) {
            for (Method met : clss.getDeclaredMethods()) {
                if (!mets.containsKey(met.getName())) {
                    mets.put(met.getName(), met);
                    logger.info(met);
                }
            }

            clss = clss.getSuperclass();
        }
        Collection<Method> returnCollection = mets.values();
        return returnCollection;
    }
}


