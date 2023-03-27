
package com.tienda2.controller;

import com.tienda2.domain.Cliente;
import com.tienda2.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author mariafernandamiranda
 */
@Controller
public class ClienteController {
    
    @Autowired
    ClienteService clienteService;
    
    @GetMapping("/")
    public String page(Model model) {
        
        var clientes = clienteService.getClientes();
        Object cliente = null;
        model.addAttribute("clientes", cliente);

        return "index";
    }
}
