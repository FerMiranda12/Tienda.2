
package com.tienda2.controller;

import com.tienda2.domain.Articulo;
import com.tienda2.domain.CarritoDetalle;
import com.tienda2.service.ArticuloService;
import com.tienda2.service.CarritoDetalleService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import static javax.swing.text.html.CSS.getAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author mariafernandamiranda
 */

@Controller
public class CarritoController {
    
    @Autowired
    CarritoDetalleService carritoDetalleService;
    
    @Autowired
    ArticuloService articuloService;
    
    @GetMapping ("/carrito/agregar/idArticulo")
    public String agregar (Articulo articulo, HttpSession session){
       
        Long idCarrito = (Long)session.getAttribute("idCarrito");
        articulo = articuloService.getArticulo(articulo);
        
        //verificar si existe en el carrito
        CarritoDetalle carritoDetalle= carritoDetalleService.getCarritoDetalle(idCarrito, articulo);
        
        if (carritoDetalle != null) {
            carritoDetalle.setCantidad(carritoDetalle.getCantidad() +1);    
        }else{
            carritoDetalle = new carritoDetalle(idCarrito, articulo, articulo.getPrecio(), 1);
        }
        
        carritoDetalleService.save(carritoDetalle);
        
        return "redirect:/";
    }
    
     @GetMapping ("/carrito/listado")
    public String listado (Model model,  HttpSession session){
        Long idCarrito = (Long)session.getAttribute("idCarrito");
        
        List<CarritoDetalle> carritoDetalles = carritoDetalleService.getCarritoDetalle(idCarrito);
        
        double montoTotal = 0.0;
        double montoImpuestos = 0.0;
        
        for(CarritoDetalle c : carritoDetalles){
            montoTotal += c.getCantidad() * c.getPrecio();
        }
    
    
    montoImpuestos = montoTotal + 0.13;
    
    model.addAttribute("carritoDetalles", carritoDetalles);
    model.addAttribute("cantidadArticulosCarrito", cantidadArticulosCarrito);
    model.addAttribute("montoImpuestos", montoImpuestos);
    model.addAttribute("montoTotal", montoTotal);
    
    return "/carrito/listado";
    }
  
}
