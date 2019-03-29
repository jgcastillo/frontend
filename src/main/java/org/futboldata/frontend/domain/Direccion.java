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
public class Direccion {

    @Id
    @GeneratedValue
    private int id;
    private String paginaWeb;
    private Integer latitud;
    private Integer longitud;
    @ManyToOne
    private Ciudad ciudad;

    public Direccion() {
    }
}
