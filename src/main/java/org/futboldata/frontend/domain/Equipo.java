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
public class Equipo {

    @Id
    @GeneratedValue
    private int id;
    private String nombre;
    private String nombreAlterno;
    private Integer status;
    private String abreviacion;
    private String logo;
    private Integer clubId;
    @ManyToOne
    private Categoria categoria;
    private Integer organizacionId;

    public Equipo() {
    }
}
