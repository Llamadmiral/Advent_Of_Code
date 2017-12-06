package com.aoc.util.log;

/**
 * @author Llamadmiral.
 */
public class Logger {
    private Class clazz;

    public Logger(final Class clazz) {
        this.clazz = clazz;
    }

    public void log(final Object object) {
        System.out.println(object);
    }
}
