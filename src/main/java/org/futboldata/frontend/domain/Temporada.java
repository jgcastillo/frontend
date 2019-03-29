package org.futboldata.frontend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
public class Temporada {

    @Id
    @GeneratedValue
    private int id;
    private String nombre;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private int status;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Competicion competicion;

    public Temporada(){}

    public Temporada(int id){
        setId(id);
    }
}
