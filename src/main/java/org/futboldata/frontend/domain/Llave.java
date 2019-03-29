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
public class Llave {

    @Id
    @GeneratedValue
    private int id;
    private String nombre;
    private int status;
    @ManyToOne
    private Fase fase;

    public Llave() {
    }

    public Llave(int id) {
        this.id = id;
    }
}
