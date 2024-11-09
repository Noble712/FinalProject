package com.jo.proyectofinal.clienteservice.controller;

import com.jo.proyectofinal.clienteservice.entidad.Cliente;
import com.jo.proyectofinal.clienteservice.impl.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return clienteService.crearCliente(cliente);
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    public Cliente obtenerClientePorId(@PathVariable Long id) {
        return clienteService.obtenerClientePorId(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Cliente actualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteDetalles) {
        return clienteService.actualizarCliente(id, clienteDetalles);
    }

    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
    }
}
