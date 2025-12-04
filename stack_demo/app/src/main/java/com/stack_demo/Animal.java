package com.stack_demo;

public interface Animal {
    /**
     * Prints generic animal sounds to stdout.
     */
    default void howl() {
        System.out.println("*Generic animal sounds*");
    }
}
