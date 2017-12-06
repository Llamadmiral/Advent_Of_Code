package com.aoc.util.log;

/**
 * @author maczaka.
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
