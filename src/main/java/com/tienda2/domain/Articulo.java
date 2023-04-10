
package com.tienda2.domain;

import jakarta.persistence.*;
import lombok.Data;

/**
 *
 * @author mariafernandamiranda
 */

@Data
@Entity
@Table(name="articulo")
public class Articulo {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArticulo;
    private Long idCategoria;
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencia;
    private boolean activo;

    public Articulo() {
    }

    public Articulo(Long idCategoria, String descripcion, String detalle, double precio, int existencia, boolean activo) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
        this.existencia = existencia;
        this.activo = activo;
    }
}
