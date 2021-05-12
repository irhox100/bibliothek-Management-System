package de.bibliothek.phase4.persistence;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table("Bibliothekar")
@Setter
@Getter
public class Bibliothekar {

    @Id
    String email;
    @Column("Telefonnummer")
    String telefonnummer;

}