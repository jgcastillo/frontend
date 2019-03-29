package org.futboldata.frontend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
public class Partido {

    @Id
    @GeneratedValue
    private int id;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String observaciones;
    @ManyToOne
    private Equipo equipoLocal;
    @ManyToOne
    private Equipo equipoVisitante;
    @ManyToOne
    private Cancha cancha;
    private Integer tx_tv;
    private Integer tx_radio;
    private Integer asistencia;
    @ManyToOne
    private StatusPartido statusPartido;
    @ManyToOne
    private Llave llave;
    @ManyToOne
    private Jornada jornada;
    private Integer golesEquipoLocal;
    private Integer golesEquipoVisitante;
    private Integer golesLocalProrroga;
    private Integer golesVisitanteProrroga;
    private Integer golesLocalPenalties;
    private Integer golesVisitantePenalties;
    private Integer numero;
    @ManyToOne
    private Categoria categoria;
    private String aprobacionNomina;

    public Partido(){}

    public Partido(int id){
        this.id = id;
    }
}
