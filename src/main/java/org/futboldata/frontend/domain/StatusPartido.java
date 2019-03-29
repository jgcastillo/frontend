package org.futboldata.frontend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
public class StatusPartido {

    @Id
    @GeneratedValue
    private int id;
    private Integer value;
    private Integer status;
    private String nombre;

    public StatusPartido() {
    }
}
