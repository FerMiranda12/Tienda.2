
package com.tienda2.service;

import com.tienda2.dao.ArticuloDao;
import com.tienda2.dao.CarritoDetalleDao;
import com.tienda2.domain.Articulo;
import com.tienda2.domain.CarritoDetalle;
import com.tienda2.domain.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mariafernandamiranda
 */

@Service
public class CarritoDetalleServicelmpl implements CarritoDetalleService{
    
    @Autowired
    CarritoDetalleDao carritoDetalleDao;

    @Override
    public CarritoDetalle getCarritoDetalle(CarritoDetalle carritoDetalle) {
        return carritoDetalleDao.findById(carritoDetalle.getIdCarrito()).orElse(null);
    }
    
     @Override
    public CarritoDetalle getCarritoDetalleArticulo(Long idCarrito, Articulo articulo) {
        return carritoDetalleDao.findbyIdCarritoAndArticulo(idCarrito, articulo);
    }

    @Override
    public List<CarritoDetalle> getCarritoDetalles(Long idCarrito) {
        return carritoDetalleDao.findbyIdCarrito(idCarrito);
    }

    @Override
    public void save(CarritoDetalle carritoDetalle) {
        carritoDetalleDao.save(carritoDetalle);
    }

    @Override
    public void delete(CarritoDetalle carritoDetalle) {
        carritoDetalleDao.deleteById(carritoDetalle.getIdCarrito());
    }

    @Override
    public void deleteAll(Long idCarrito) {
        carritoDetalleDao.deleteByIdCarrito(idCarrito);
    }  

}
