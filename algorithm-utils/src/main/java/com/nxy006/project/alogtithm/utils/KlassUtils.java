package com.nxy006.project.alogtithm.utils;

public class KlassUtils<T> {
    public static <T> T createCurrentInstance(Class<T> klass) {
        try {
            String className = Thread.currentThread().getStackTrace()[2].getClassName();
            Object instance = Class.forName(className).newInstance();
            if (klass.isInstance(instance)) {
                return (T) instance;
            }
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        throw new RuntimeException("incorrect class type");
    }

    public static <T> T createInstance(Class<T> klass) {
        try {
            Object instance = klass.newInstance();
            if (klass.isInstance(instance)) {
                return (T) instance;
            }
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        throw new RuntimeException("incorrect class type");
    }
}
