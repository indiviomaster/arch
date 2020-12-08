package ru.indivio.homecrm.entities;

public class Note {
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    String title;
    String text;

    public Note(int id, String title, String text) {
        this.id=id;
        this.title=title;
        this.text=text;
    }
    public Note(){}
}
