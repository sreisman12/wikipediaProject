package com.viome.model;

public class WikiPage extends Resource {

    private String title;
    private String language;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

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
                ", language='" + language + '\'' +
                ", id=" + id +
                ", content=" + content +
                '}';
    }
}
