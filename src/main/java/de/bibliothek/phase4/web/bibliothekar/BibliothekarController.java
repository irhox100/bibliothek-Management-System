package de.bibliothek.phase4.web.bibliothekar;

import de.bibliothek.phase4.service.BibliothekarService;
import de.bibliothek.phase4.service.NutzerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BibliothekarController {

    NutzerService nutzerService;
    BibliothekarService bibService;

    public BibliothekarController(NutzerService nutzerService, BibliothekarService bibService){
        this.nutzerService = nutzerService;
        this.bibService = bibService;
    }


    @GetMapping("/bib")
    public String getBibIndex(Model model) {
        model.addAttribute("artikeln", nutzerService.findAll());
        model.addAttribute("exemplare", nutzerService.getExemplareIDsForArtikel());
        model.addAttribute("genres", nutzerService.getGenresByArtikel());
        model.addAttribute("ausleihen", bibService.findAll());
        return "BibliothekarIndex";
    }
}
