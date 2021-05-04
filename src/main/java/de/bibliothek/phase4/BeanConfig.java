package de.bibliothek.phase4;

import de.bibliothek.phase4.persistence.ArtikelRepository;
import de.bibliothek.phase4.service.ArtikelService;
import de.bibliothek.phase4.service.ArtikelServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ArtikelService getArtikelService(ArtikelRepository artikelRepository){
        return new ArtikelServiceImpl(artikelRepository);
    }
}
