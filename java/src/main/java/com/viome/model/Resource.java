package com.viome.model;

public class Resource<T> {
    int id;
    T content;

    public Resource(int id, T content) {
        this.id = id;
        this.content = content;
    }
}
