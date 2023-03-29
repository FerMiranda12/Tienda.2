
package com.tienda2.dao;

import com.tienda2.domain.Cliente;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author mariafernandamiranda
 */
public interface ClienteDao extends CrudRepository<Cliente, Long> {
    
}
