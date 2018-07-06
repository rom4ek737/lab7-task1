package com.epam.lab7.hw2.task6;

import java.lang.reflect.Method;

public class TestInvoke {
    public static void main(String[] args) throws Exception {
        new TestInvoke().newMethod();
    }

    public void myMethod(String... string) throws Exception {
        System.err.println(string[0]);
        System.out.println(string[1]);
        System.out.println(string[2]);
    }

    public void myMethod(String a, int... args) throws Exception {
        System.out.println(a + args[5]);
        System.out.println(a + args[1]);

    }

    void newMethod() throws Exception {
        String path = "com.epam.lab7.hw2.task6.TestInvoke";
        String[] a = new String[]{"yes", "no", "sometimes"};
        int[] mas = {5, 6, 3, 6, 7, 5, 6};
        System.err.println(a.getClass());
        Method m = getClass().getMethod("myMethod", a.getClass());
        m.invoke(this, new Object[]{a});
        Object[] obj = {"hello everybody", mas};
        Class<?>[] params = new Class[obj.length];
        for (int i = 0; i < obj.length; i++) {
            if (obj[i] instanceof Integer[]) {
                params[i] = Integer.TYPE;
            } else if (obj[i] instanceof String) {
                params[i] = String.class;
            }
        }
        Class<?> cls = Class.forName(path);

        Method met = cls.getDeclaredMethod("myMethod", new Class[]{String.class, Integer.class});
        Object instance = cls.newInstance();
        Object[] args = {mas};
        Object ar = "hello";
        met.invoke(instance, new Object[]{ar, args});
    }
}
