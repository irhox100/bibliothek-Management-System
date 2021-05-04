package de.bibliothek.phase4.persistence;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("Nutzer")
public class Nutzer {

    @Id
    String email;
    @Column("Geburtsdatum")
    String geburtsdatum;
    @Column("Nachname")
    String nachname;
    @Column("Vorname")
    String vorname;
    @Column("Passwort")
    String passwort;

    public Nutzer(String email, String geburtsdatum, String nachname, String vorname, String passwort) {
        this.email = email;
        this.geburtsdatum = geburtsdatum;
        this.nachname = nachname;
        this.vorname = vorname;
        this.passwort = passwort;
    }

    public Nutzer(){

    }
}
