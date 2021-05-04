package de.bibliothek.phase4.web;

import de.bibliothek.phase4.service.ArtikelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class NutzerController {

    ArtikelService artikelService;

    public NutzerController(ArtikelService artikelService){
        this.artikelService = artikelService;
    }

    @GetMapping("/")
    public String getIndex(Model model){

        model.addAttribute("artikeln", artikelService.findAll());
        model.addAttribute("exemplare", artikelService.getExemplareCountForArtikel());
        model.addAttribute("genres", artikelService.getGenresByArtikel());
        return "index";
    }

    @GetMapping("/registerBib")
    public String getBibliothekarForm(){
        return "BibliothekarForm";
    }

    @GetMapping("/registerKunde")
    public String getKundeForm(){
        return "KundeForm";
    }

    @PostMapping("/registerBib")
    public String postBibliothekar(){
        //TODO
        return "redirect:/";
    }

    @PostMapping("/registerKunde")
    public String postKunde(){
        //TODO
        return "redirect:/";
    }
}
