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
public class Grupo {

    @Id
    @GeneratedValue
    private int id;
    private String nombre;
    private int status;
    @ManyToOne(optional = true)
    private Fase fase;

    public Grupo() {
    }

    public Grupo(int id) {
        this.id = id;
    }
}
