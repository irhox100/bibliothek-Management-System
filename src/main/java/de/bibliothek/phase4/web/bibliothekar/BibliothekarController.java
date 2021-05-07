package de.bibliothek.phase4.web.bibliothekar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BibliothekarController {

    @GetMapping("/bib")
    public String getBibIndex(){
        return "BibliothekarIndex";
    }
}
