
package com.tienda2.dao;

import com.tienda2.domain.Articulo;
import com.tienda2.domain.CarritoDetalle;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author mariafernandamiranda
 */
public interface CarritoDetalleDao extends CrudRepository<CarritoDetalle, Long>{
    
    List<CarritoDetalle> findbyIdCarrito(Long idCarrito); //metodo para encontrar por id del carrito
    
    CarritoDetalle findbyIdCarritoAndArticulo(Long idCarrito, Articulo articulo); //metodo para buscar por id del carrito y el id del articulo
    
    void deleteByIdCarrito(Long idCarrito); // metodo para borrar todo el carrito
}
