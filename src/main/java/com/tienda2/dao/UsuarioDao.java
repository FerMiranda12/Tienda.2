
package com.tienda2.dao;

/**
 *
 * @author mariafernandamiranda
 */

import com.tienda2.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{
    Usuario findByUsername(String usuername);    
}
