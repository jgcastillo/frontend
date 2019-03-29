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
public class Ciudad {

    @Id
    private int id;
    private String ciudad;
    @ManyToOne
    private Pais pais;

    public Ciudad() {
    }
}
