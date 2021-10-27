package com.kominal.notes.notesrest.Note;

import java.util.UUID;

public class Note {

    private String id;
    private String author;
    private String title;
    private String text;

    public Note(){}

    public Note(String id, String author, String title, String text) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.text = text;
    }

    public Note(String author, String title, String text) {
        this(UUID.randomUUID().toString(), author, title, text);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
