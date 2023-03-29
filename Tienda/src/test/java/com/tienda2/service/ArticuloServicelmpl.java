
package com.tienda2.service;

import com.tienda2.dao.ArticuloDao;
import com.tienda2.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mariafernandamiranda
 */

@Service
 public class ArticuloServicelmpl implements ArticuloService {

     @Autowired
     ArticuloDao articuloDao;

    @Override
    @Transactional(readOnly = true) //para solo hacer lecturas
    public List<Articulo> getArticulos(boolean activos) {
        var lista = (List<Articulo>) articuloDao.findAll();
        
        if(activos) {
            lista.removeIf((e -> !e.isActivo()));
        }
         return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Articulo getArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Articulo articulo) {
        articuloDao.save(articulo);
    }

    @Override
    @Transactional
    public void delete(Articulo articulo) {
        articuloDao.deleteById(articulo.getIdArticulo());
    }
}


