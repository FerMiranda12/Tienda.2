
package com.tienda2.service;

import com.tienda2.domain.Carrito;

/**
 *
 * @author mariafernandamiranda
 */
public interface CarritoService {
    
    public Carrito getCarrito(Carrito carrito);
    
    public Carrito getCarrito(Long idCarrito);
}
