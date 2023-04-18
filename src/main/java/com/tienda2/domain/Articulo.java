
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
    @Column(name="id_articulo")
    private Long idArticulo;
    private Long idCategoria;
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencia;
    private boolean activo;
    private String rutaImagen;

    public Articulo() {
    }

    public Articulo(Long idCategoria, String descripcion, String detalle, double precio, int existencia, boolean activo, String rutaImagen) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
        this.existencia = existencia;
        this.activo = activo;
        this.rutaImagen = rutaImagen;
    }

    
}
