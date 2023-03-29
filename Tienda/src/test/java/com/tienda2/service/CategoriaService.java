
package com.tienda2.service;

import com.tienda2.domain.Categoria;
import com.tienda2.domain.Cliente;
import java.util.List;

/**
 *
 * @author mariafernandamiranda
 */
public interface CategoriaService {
    
    public List<Categoria> getCategorias(boolean activos);
    
    public Categoria getCategoria(Categoria categoria);
    
    public void save(Categoria categoria); //sirve para mordificar e insertar un registro
    
    public void delete(Categoria categoria);
}
