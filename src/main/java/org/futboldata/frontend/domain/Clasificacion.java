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
public class Clasificacion {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private Jornada jornada;
    @ManyToOne
    private Equipo equipo;
    @ManyToOne
    private Partido partido;
    @ManyToOne
    private Grupo grupo;
    private Integer jJugados;
    private Integer jGanados;
    private Integer jEmpatados;
    private Integer jPerdidos;
    private Integer golesFavor;
    private Integer golesContra;
    private Integer diferencia;
    private Integer puntos;
}
