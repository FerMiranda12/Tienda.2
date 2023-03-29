
package com.tienda2.service;

import com.tienda2.domain.Articulo;
import java.util.List;

/**
 *
 * @author mariafernandamiranda
 */
public interface ArticuloService {
    
    public List<Articulo> getArticulos(boolean activos);
    
    public Articulo getArticulo(Articulo articulo);
    
    public void save(Articulo articulo); //sirve para mordificar e insertar un registro
    
    public void delete(Articulo articulo);
}
