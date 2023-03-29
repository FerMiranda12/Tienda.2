
package com.tienda2.service;

/**
 *
 * @author mariafernandamiranda
 */
import com.tienda2.domain.Cliente;
import java.util.List;


public interface ClienteService {
    
    public List<Cliente> getClientes();
    
    public Cliente getCliente(Cliente cliente);
    
    public void save(Cliente cliente); // sirve para mordificar e insertar un registro
    
    public void delete(Cliente clienteo);
 
}

