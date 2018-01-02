package com.aoc.util.modulefactory;

/**
 * @author maczaka.
 */
public class ModuleException extends Throwable {
    ModuleException(final String s) {
        super(s);
    }

    ModuleException(final Exception e) {
        super(e);
    }
}
