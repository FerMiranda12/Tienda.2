
package com.tienda2.dao;

import com.tienda2.domain.Carrito;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author mariafernandamiranda
 */
public interface CarritoDao extends CrudRepository<Carrito, Long>{
    
    Optional <Carrito> findbyIdCliente(Long idCliente); //busca el carrito de la persona por el id del cliente 
}
