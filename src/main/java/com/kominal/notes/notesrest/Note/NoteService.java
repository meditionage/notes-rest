package com.kominal.notes.notesrest.Note;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private List<Note> notes= new ArrayList<>();
    private NoteService(){
        notes.addAll(List.of(
                new Note("Mark", "Note1", "something important"),
                new Note("Lisa", "Note2", "something important")
        ));
    }

    public List<Note> getNotes() {
        return notes;
    }


    public Optional<Note> getNoteById(@PathVariable String id) {
        for (Note n: getNotes()) {
            if (n.getId().equals(id)){
                return Optional.of(n);
            }
        }
        return Optional.empty();
    }

    public void addNote(Note note) {
        Note newNote = new Note(note.getAuthor(), note.getTitle(), note.getText());
        notes.add(newNote);
    }

    public void updateNote(Note note, String id){
        int counter = 0;
        for (Note note1 : notes){
            if (note1.getId().equals(id)){
                notes.set(counter, note);
            }
            counter++;
        }
    }

    public void deleteNote(String id) {
        notes.removeIf(note -> note.getId() == id);
    }
}
