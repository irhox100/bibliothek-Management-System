package de.bibliothek.phase4.persistence;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table("Bibliothekar")
@Setter
public class Bibliothekar {

    @Id
    String email;
    @Getter
    @Column("Telefonnummer")
    String telefonnummer;
    @Getter
    Nutzer nutzer;

    public Bibliothekar(String email, String telefonnummer, Nutzer nutzer) {
        this.email = email;
        this.telefonnummer = telefonnummer;
        this.nutzer = nutzer;
    }

    public Bibliothekar(){

    }

    public String getEmail() {
        return nutzer.getEmail();
    }
}
