package org.futboldata.frontend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
public class Fase {

    @Id
    @GeneratedValue
    private int id;
    private String nombre;
    private int tipoFase;
    private int status;
    @ManyToOne(optional = true)
    private Temporada temporada;

    public Fase() {
    }

    public Fase(int id) {
        setId(id);
    }
}
