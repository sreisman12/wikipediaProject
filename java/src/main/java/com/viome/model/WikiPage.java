package com.viome.model;

public class WikiPage {

    private String title;
    private String language;
    private String id;
    private String content;

    public WikiPage(String title, String language, String id, String content) {
        this.title = title;
        this.language = language;
        this.id = id;
        this.content = content;
    }

    public WikiPage() {
    }

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
