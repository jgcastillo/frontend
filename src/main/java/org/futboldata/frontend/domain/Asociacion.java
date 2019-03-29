package org.futboldata.frontend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
public class Asociacion {

    @Id
    @GeneratedValue
    private int id;
    private String nombre;
    private int status;
    private String logo;

    public Asociacion(){}

    public Asociacion(int id){
        this.setId(id);
    }
}
