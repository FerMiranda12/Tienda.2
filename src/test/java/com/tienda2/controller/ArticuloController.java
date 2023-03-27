
package com.tienda2.controller;

import com.tienda2.domain.Articulo;
import com.tienda2.service.ArticuloService;
import com.tienda2.service.CategoriaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class ArticuloController {
    
    @Autowired
    ArticuloService articuloService;
    
    @Autowired
    CategoriaService categoriaService;
    
    @GetMapping("/articulo/listado")
    public String page(Model model) {
        log.info("Ahora estás conectado con la base de datos práctica");
        var articulos = articuloService.getArticulos(false);
        Object articulo = null;
        model.addAttribute("articulo", articulo);

        return "/articulo/listado";
    }
    
    @GetMapping("/articulo/nuevo")
    public String nuevoArticulo(Articulo articulo, Model model) {
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        return "/articulo/modificar";
    }
    
    @PostMapping("/articulo/guardar")
    public String salvarArticulo(Articulo articulo) {
        articuloService.save(articulo);
        return "redirect:/articulo/listado";
    }
    
    @GetMapping("/articulo/modificar/{idArticulo")
    
    public String modificarArticulo(Articulo Articulo, Model model) {
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        
        Articulo = articuloService.getArticulo(Articulo);
        model.addAttribute("articulo", Articulo);
        return "/articulo/modificar";
    }

    @GetMapping("/articulo/eliminar/{idArticulo}")
    public String eliminarArticulo(Articulo articulo) {
        articuloService.delete(articulo);
        return "redirect:/carticulo/listado";
    } 
}


