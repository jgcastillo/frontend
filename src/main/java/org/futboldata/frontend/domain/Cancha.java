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
public class Cancha {

    @Id
    @GeneratedValue
    private int id;
    private String nombre;
    private Integer capacidad;
    private String superficie;
    private String medidas;
    private String foto;
    private Integer status;
    @ManyToOne
    private Direccion direccion;
    private Integer coordenadaLong;
    private Integer coordenadaLat;
    private Integer organizacionId;


    public Cancha() {
    }
}
