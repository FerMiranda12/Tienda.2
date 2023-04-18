package com.tienda2.controller;

import com.tienda2.dao.UsuarioDao;
import com.tienda2.domain.Carrito;
import com.tienda2.domain.CarritoDetalle;
import com.tienda2.domain.Usuario;
import com.tienda2.service.ArticuloService;
import com.tienda2.service.CarritoDetalleService;
import com.tienda2.service.CarritoService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    ArticuloService articuloService;

    @Autowired
    UsuarioDao usuarioDao;

    @Autowired
    CarritoService carritoService;
    
    @Autowired
    CarritoDetalleService carritoDetalleService;

    @GetMapping("/")
    public String inicio(Model model, HttpServletRequest request) {
        
        //obtener ususario loggeado
        Object principal = SecurityContexHolder.getContext().getAuthentication().getPrincipal();
        UserDetails user = null;
        
        if(principal instanceof UserDetails) {
            
            user = (UserDetails) principal;
        }
    
        //validar si el usuario es de un cliente
        boolean esCliente = false;
        if (user != null) {
            Usuario usuario = usuarioDao.findByUsername(user.getUsername());
        }

        if (usuario.getIdCliente() != null &&  != 0) {
            esCliente = true;
            Carrito carrito = carritoService.getIdCliente(usuario.getIdCliente());

            request.getSession().setAttribute(idCliente, usuario.getIdCliente());
            request.getSession().setAttribute(idCarrito, carrito.getIdCarrito());
            request.getSession().setAttribute("esCliente", esCliente);

            //consultar items del carrito
            List<CarritoDetalle> carritoDetalle = carritoDetalleService.getCarritoDetalles(carrito.getIdCarrito());
            model.addAttribute("cantidadArticulosCarrito", carritoDetalle.size());

        }
        
        var articulos = articuloService.getArticulos(true);
        model.addAttribute("articulos", articulos);
        model.addAttribute("esCliente", esCliente);
        
        return "index";
    }
}
