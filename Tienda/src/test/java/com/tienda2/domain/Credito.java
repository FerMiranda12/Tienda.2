
package com.tienda2.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author mariafernandamiranda
 */

@Data
@Entity
@Table(name="credito")
public class Credito implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_credito") // permite indicar con cual campo de la base de datos se va a mapear
    private Long codigoCredito;
    private double limite;

    public Credito() {
    }

    public Credito(double limite) {
        this.limite = limite;
    }
}
