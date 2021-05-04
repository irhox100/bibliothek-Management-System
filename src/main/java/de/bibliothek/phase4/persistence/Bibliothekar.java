package de.bibliothek.phase4.persistence;

import org.springframework.data.annotation.Id;

public class Bibliothekar {

    @Id
    String email;
    String telefonnummer;
}
