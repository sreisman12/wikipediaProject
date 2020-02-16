package com.viome.model;

public class WikiPage extends Resource<String> {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "WikiPage{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", content=" + content +
                '}';
    }
}
