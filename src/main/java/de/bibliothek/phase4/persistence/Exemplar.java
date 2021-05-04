package de.bibliothek.phase4.persistence;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@ToString
@Table("Exemplar")
public class Exemplar {

    @Id
    private Long id;
    @Column("Anschaffungspreis")
    private Double anschaffungspreis;
    @Column("StandortID")
    private Long standortId;


    public Exemplar(Long id, Double anschaffungspreis, Long standortId) {
        this.id = id;
        this.anschaffungspreis = anschaffungspreis;
        this.standortId = standortId;
    }

}
