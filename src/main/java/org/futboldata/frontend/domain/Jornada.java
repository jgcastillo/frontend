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
public class Jornada {

    @Id
    @GeneratedValue
    private int id;
    private int numero;
    private String alias;
    private int status;
    @ManyToOne(optional = true)
    private Grupo grupo;

    public Jornada() {
    }

    public Jornada(int id){
        this.id = id;
    }
}
