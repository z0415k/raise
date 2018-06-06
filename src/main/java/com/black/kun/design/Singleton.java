package com.black.kun.design;

public class Singleton {
    private Singleton() {
    }

    private static class SingletonBuild {
        private static Singleton value = new Singleton();
    }

    private Singleton getInstance() {
        return SingletonBuild.value;
    }
}
