package de.bibliothek.phase4.web.kunde;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KundeController {

    @GetMapping("/kunde")
    public String getBibIndex(){
        return "kundeIndex";
    }
}
