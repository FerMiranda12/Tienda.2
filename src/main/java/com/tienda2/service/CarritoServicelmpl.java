
package com.tienda2.service;

import com.tienda2.dao.CarritoDao;
import com.tienda2.domain.Carrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mariafernandamiranda
 */

@Service
public class CarritoServicelmpl implements CarritoService{

    @Autowired
    CarritoDao carritoDao;
    
    @Override
    public Carrito getCarrito(Carrito carrito) {
        
        return carritoDao.findById(carrito.getIdCarrito()).orElse(null);
    }

    @Override
    public Carrito getCarritotoCliente(Long idCarrito) {
        Carrito carritoCliente = CarritoDao.findByIdCliente(idCarrito()).orElse(null); //para evaluar que ya existe el carrito
        
        //evaluar si el carrito exixte y si no mandarlo a crear
        if (carritoCliente == null){ //si no existe
            Carrito carritoNuevo = new Carrito (idCarrito);//se crea nuevo objeto o sea carrito
            carritoCliente = carritoDao.save(carritoNuevo);//y esto es para guardar en memoria
        }
        
        return carritoCliente;//retorna el carrito simpre
    } 
}
