
package com.tienda2.controller;

import com.tienda2.domain.Cliente;
import com.tienda2.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class IndexController {
    
    @Autowired
    ClienteService clienteService;
    
    @GetMapping("/cliente/listado")
    public String page(Model model) {
        log.info("Ahora estás conectado con la base de datos práctica");
        var clientes = clienteService.getClientes();
        Object cliente = null;
        model.addAttribute("clientes", cliente);

        return "/cliente/listado";
    }
    
    @GetMapping("/cliente/nuevo")
    public String nuevoEstado(Cliente cliente) {
        return "/cliente/modificar";
    }
    
    @PostMapping("/cliente/salvar")
    public String salvarCliente(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }
    
    @GetMapping("/cliente/modificar/{idCliente}")
    
    public String modificarCliente(Cliente Cliente, Model model) {
        Cliente = clienteService.getCliente(Cliente);
        model.addAttribute("cliente", Cliente);
        return "/cliente/modificar";
    }

    @GetMapping("/cliente/eliminar/{idCliente}")
    public String eliminarEstado(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/cliente/listado";
    } 
}
