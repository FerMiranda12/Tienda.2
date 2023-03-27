package com.tienda2.service;

/**
 *
 * @author mariafernandamiranda
 */
import com.tienda2.dao.ClienteDao;
import com.tienda2.dao.CreditoDao;
import com.tienda2.domain.Cliente;
import com.tienda2.domain.Credito;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mariafernandamiranda
 */
@Service
public class ClienteServicelmpl implements ClienteService {

    @Autowired
    ClienteDao clienteDao;

    @Autowired
    CreditoDao creditoDao;

    @Override
    @Transactional(readOnly = true) //para solo hacer lecturas
    public List<Cliente> getClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        Credito credito = cliente.getCredito();
        credito = creditoDao.save(credito);

        cliente.setCredito(credito);
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.deleteById(cliente.getIdCliente());
    }
}
