package com.ronnymigue.model;

public class Actor {

    private final String name;
    private final String born;

    public Actor(String name, String born) {

        this.name = name;
        this.born = born;
    }

    public String getName() {
        return name;
    }

    public String getBorn() {
        return born;
    }
}
