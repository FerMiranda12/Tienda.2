
package com.tienda2.controller;

import com.tienda2.domain.Categoria;
import com.tienda2.service.CategoriaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class CategoriaController {
    
    @Autowired
    CategoriaService categoriaService;
    
    @GetMapping("/categoria/listado")
    public String page(Model model) {
        log.info("Ahora estás conectado con la base de datos práctica");
        var categorias = categoriaService.getCategorias(false);
        Object categoria = null;
        model.addAttribute("categoria", categoria);

        return "/categoria/listado";
    }
    
    @GetMapping("/categoria/nuevo")
    public String nuevoCategoria(Categoria categoria) {
        return "/categoria/modificar";
    }
    
    @PostMapping("/categoria/salvar")
    public String salvarCategoria(Categoria categoria) {
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }
    
    @GetMapping("/categoria/modificar/{idCategoria}")
    
    public String modificarCategoria(Categoria Categoria, Model model) {
        Categoria = categoriaService.getCategoria(Categoria);
        model.addAttribute("categoria", Categoria);
        return "/categoria/modificar";
    }

    @GetMapping("/categoria/eliminar/{idCategoria}")
    public String eliminarCategoria(Categoria categoria) {
        categoriaService.delete(categoria);
        return "redirect:/categoria/listado";
    } 
}

