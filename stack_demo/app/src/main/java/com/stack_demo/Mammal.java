package com.stack_demo;

public interface Mammal {
    // default speak() implementation
    default void speak() {
        System.out.println("*Generic mammal sound*");
    }
}
