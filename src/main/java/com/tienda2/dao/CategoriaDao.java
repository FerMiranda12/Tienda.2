
package com.tienda2.dao;

import com.tienda2.domain.Categoria;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author mariafernandamiranda
 */
public interface CategoriaDao extends CrudRepository<Categoria, Long> {
    
}
