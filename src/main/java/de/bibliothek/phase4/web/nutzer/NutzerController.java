package de.bibliothek.phase4.web.nutzer;

import de.bibliothek.phase4.service.NutzerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class NutzerController {

    NutzerService nutzerService;

    public NutzerController(NutzerService nutzerService){
        this.nutzerService = nutzerService;
    }

    @GetMapping("/")
    public String getIndex(Model model){

        model.addAttribute("artikeln", nutzerService.findAll());
        model.addAttribute("exemplare", nutzerService.getExemplareCountForArtikel());
        model.addAttribute("genres", nutzerService.getGenresByArtikel());
        return "index";
    }

    @GetMapping("/registerBib")
    public String getBibliothekarForm(Model model){
        model.addAttribute("bibliothekar", new BibliothekarFormData());
        return "BibliothekarForm";
    }

    @GetMapping("/registerKunde")
    public String getKundeForm(Model model){
        model.addAttribute("kunde", new KundeFormData());
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
    public String postKunde(KundeFormData kunde){
        nutzerService.createKunde(kunde.getEmail(), kunde.getGeburtsdatum(), kunde.getVorname(), kunde.getNachname(),
                                kunde.getPasswort(), kunde.getGuthaben(), kunde.getBeitragsbefreit(),
                                kunde.getStadt(), kunde.getStrasse(), kunde.getPlz(), kunde.getHausnummer());
        return "redirect:/";
    }
}
