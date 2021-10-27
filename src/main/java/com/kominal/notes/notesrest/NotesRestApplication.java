package com.kominal.notes.notesrest;

import com.kominal.notes.notesrest.Note.Note;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class NotesRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotesRestApplication.class, args);
	}

}
