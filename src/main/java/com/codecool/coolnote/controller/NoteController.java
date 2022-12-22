package com.codecool.coolnote.controller;


import com.codecool.coolnote.model.Note;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.LinkedList;
import java.util.List;

@Controller
public class NoteController {

    List<Note> noteList = new LinkedList<>();

    @GetMapping("/")
    public String home(Model model) {
        String myMessage;
        if (noteList.isEmpty()) {
            myMessage = "There is no notes";
        } else {
            myMessage = "";
        }
        model.addAttribute("message", myMessage);
        model.addAttribute("notes", noteList);
        return "main-page";
    }

    @GetMapping("/note")
    public String addNote(Model model) {
        model.addAttribute("newNote", new Note());
//        return "redirect:/main-page";
        return "adduser";
    }

    @PostMapping("/note")
    public String addNewNote(@ModelAttribute Note note) {
        noteList.add(note);
        return "redirect:/";
    }

    @GetMapping("/editNote/{id}")
    public String getEditNote(Model model, @PathVariable("id") String id) {
        Note noteToEdit = noteList.stream().filter(n -> id.equals(n.getTime())).findFirst().get();
        model.addAttribute("editedNote", noteToEdit);
        return "editNote";
    }

    @PostMapping("/editNote/{id}")
    public String postEditNote(@ModelAttribute("note") Note editedNote, @PathVariable("id") String id) {
        noteList.add(editedNote);
        return "redirect:/";
    }
}



