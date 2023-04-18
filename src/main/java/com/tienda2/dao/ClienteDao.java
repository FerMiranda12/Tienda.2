
package com.tienda2.dao;

import com.tienda2.domain.Cliente;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author mariafernandamiranda
 */
public interface ClienteDao extends CrudRepository<Cliente, Long> {
    
    List<Cliente> findByCorreo (String correo);
}
