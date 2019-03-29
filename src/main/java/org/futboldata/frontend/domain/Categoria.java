package org.futboldata.frontend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue
    private int id;
    private String nombre;
    private String Descripcion;
    private Integer tiempoJuego;
    private Integer status;
    private Integer organizacionId;

    public Categoria() {
    }
}
