
package com.tienda2.dao;

import com.tienda2.domain.Articulo;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author mariafernandamiranda
 */
public interface ArticuloDao extends CrudRepository<Articulo, Long> {
    
}
