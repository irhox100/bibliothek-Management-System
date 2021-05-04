package de.bibliothek.phase4;

import de.bibliothek.phase4.persistence.ArtikelRepository;
import de.bibliothek.phase4.persistence.NutzerRepository;
import de.bibliothek.phase4.service.ArtikelService;
import de.bibliothek.phase4.service.ArtikelServiceImpl;
import de.bibliothek.phase4.service.NutzerService;
import de.bibliothek.phase4.service.NutzerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ArtikelService getArtikelService(ArtikelRepository artikelRepository){
        return new ArtikelServiceImpl(artikelRepository);
    }

    @Bean
    public NutzerService getNutzerService(NutzerRepository nutzerRepository){
        return new NutzerServiceImpl(nutzerRepository);
    }
}
