
package com.tienda2.service;

import com.tienda2.dao.CategoriaDao;
import com.tienda2.domain.Categoria;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mariafernandamiranda
 */

@Service
 public class CategoriaServicelmpl implements CategoriaService {

     @Autowired
     CategoriaDao categoriaDao;

    @Override
    @Transactional(readOnly = true) //para solo hacer lecturas
    public List<Categoria> getCategorias(boolean activos) {
        var lista = (List<Categoria>) categoriaDao.findAll();
        
        if(activos) {
            lista.removeIf((e -> !e.isActivo()));
        }
         return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.deleteById(categoria.getIdCategoria());
    }
}

