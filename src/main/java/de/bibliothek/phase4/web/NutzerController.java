package de.bibliothek.phase4.web;

import de.bibliothek.phase4.service.ArtikelService;
import de.bibliothek.phase4.service.NutzerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class NutzerController {

    ArtikelService artikelService;
    NutzerService nutzerService;

    public NutzerController(ArtikelService artikelService, NutzerService nutzerService){
        this.artikelService = artikelService;
        this.nutzerService = nutzerService;
    }

    @GetMapping("/")
    public String getIndex(Model model){

        model.addAttribute("artikeln", artikelService.findAll());
        model.addAttribute("exemplare", artikelService.getExemplareCountForArtikel());
        model.addAttribute("genres", artikelService.getGenresByArtikel());
        return "index";
    }

    @GetMapping("/registerBib")
    public String getBibliothekarForm(Model model){
        model.addAttribute("bibliothekar", new BibliothekarFormData());
        return "BibliothekarForm";
    }

    @GetMapping("/registerKunde")
    public String getKundeForm(){
        return "KundeForm";
    }

    @PostMapping("/registerBib")
    public String postBibliothekar(BibliothekarFormData bibliothekar){
        nutzerService.createBibliothekar(bibliothekar.getEmail(), bibliothekar.getGeburtsdatum(),
                                        bibliothekar.getNachname(), bibliothekar.getVorname(),
                                            bibliothekar.getPasswort(), bibliothekar.getTelefonnummer());
        return "redirect:/";
    }

    @PostMapping("/registerKunde")
    public String postKunde(){
        //TODO
        return "redirect:/";
    }
}
