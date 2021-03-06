package de.bibliothek.phase4;

import de.bibliothek.phase4.persistence.ArtikelRepository;
import de.bibliothek.phase4.persistence.AusleiheRepository;
import de.bibliothek.phase4.persistence.NutzerRepository;
import de.bibliothek.phase4.service.BibliothekarService;
import de.bibliothek.phase4.service.BibliothekarServiceImpl;
import de.bibliothek.phase4.service.NutzerService;
import de.bibliothek.phase4.service.NutzerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public NutzerService getNutzerService(NutzerRepository nutzerRepository, ArtikelRepository artikelRepository){
        return new NutzerServiceImpl(nutzerRepository, artikelRepository);
    }

    @Bean
    public BibliothekarService getBibliothekarService(AusleiheRepository ausleiheRepository){
        return new BibliothekarServiceImpl(ausleiheRepository);
    }

}
