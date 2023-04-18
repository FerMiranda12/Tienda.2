
package com.tienda2.service;

import com.tienda2.domain.Articulo;
import com.tienda2.domain.CarritoDetalle;
import java.util.List;

/**
 *
 * @author mariafernandamiranda
 */
public interface CarritoDetalleService {
    
    public List<CarritoDetalle> getCarritoDetalle(CarritoDetalle carritoDetalle); //para traer todos los detalles
    
    public CarritoDetalle getCarritoDetalleArticulo (Long idCarrito, Articulo articulo); // para traer un detalle en especifico
    
    public List<CarritoDetalle> getCarritoDetalles(Long idCarrito); //para traer todos los detalles
    
    public void save (CarritoDetalle carritoDetalle);
    
    public void delete (CarritoDetalle carritoDetalle);
    
    public void deleteAll (Long idCarrito);
}
