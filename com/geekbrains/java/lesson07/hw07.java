package com.geekbrains.java.lesson07;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class hw07 {
    public static void main(String[] args) {
        TestingClass c=new TestingClass();
        start(c.getClass());
    }

    public static void start(Class c) {
        //проверяем кол-во Before и After
        Method after = null;
        Method before = null;
        HashMap<Integer, LinkedList<Method>> tests=new HashMap<>();
        for (Method m : c.getMethods()) {
            if (m.getAnnotation(BeforeSuite.class) != null) {
                if (before != null) throw new RuntimeException("wrong amount of after method");
                before = m;
            }
            if (m.getAnnotation(AfterSuite.class) != null) {
                if (after != null) throw new RuntimeException("wrong amount of after method");
                after = m;
            }
            if (m.getAnnotation(Test.class) != null) {
                int p=m.getAnnotation(Test.class).priority();
                if(p<0 || p>10) throw new RuntimeException("Wrong priority value. Should be between 0 and 10");
                if(!tests.containsKey(p))tests.put(p,new LinkedList<>());
                tests.get(p).add(m);
            }

        }
        try {
        if(before!=null)before.invoke(null);
        for(Integer i:tests.keySet()) {
            for (Method m : tests.get(i)) {
                m.invoke(null);
            }
        }
        if(after!=null)after.invoke(null);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
