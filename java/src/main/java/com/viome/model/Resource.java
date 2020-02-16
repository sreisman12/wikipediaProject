package com.viome.model;

public class Resource<T> {
    protected int id;
    protected T content;

    public Resource(int id, T content) {
        this.id = id;
        this.content = content;
    }

    public Resource() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
