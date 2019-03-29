package org.futboldata.frontend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
public class Competicion {

    @Id
    @GeneratedValue
    private int id;
    private String nombre;
    private int status;
    private String descripcion;
    private String logo;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Asociacion asociacion;

    public Competicion(){}

    public Competicion(int id){
        setId(id);
    }
}
