package com.kominal.notes.notesrest.Note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/note")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @RequestMapping( method = RequestMethod.GET)
    public List<Note> getNotes() {
        return noteService.getNotes();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Note> getNoteById(@PathVariable("id") String id){
        return noteService.getNoteById(id);
    }

    @RequestMapping( method = RequestMethod.POST)
    public String postNote(@RequestBody Note note){
        noteService.addNote(note);
        System.out.println("(Service Side) Creating note: " + note.toString());
        return "Added Note : "+note.toString();
    }

    @RequestMapping(produces = "application/json", method = RequestMethod.PUT, value = "/{id}")
    public String updateNote(@RequestBody Note note, @PathVariable("id") String id) {
        System.out.println("(Service Side) Update note: " + noteService.getNoteById(id).toString());
        noteService.updateNote(note, id);
        return "Updated Note : "+noteService.getNoteById(id).toString();
    }

    @RequestMapping(produces = "application/json", method = {RequestMethod.DELETE, RequestMethod.GET}, value = "/{id}")
    public String deleteNote(@PathVariable("id") String id) {
        System.out.println("(Service Side) Delete note: " + noteService.getNoteById(id).toString());
        noteService.deleteNote( id);
        return "Deleted Note : "+ noteService.getNoteById(id).toString();
    }

}
