package com.jo.proyectofinal.clienteservice.impl;

import com.jo.proyectofinal.clienteservice.entidad.Cliente;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ClienteService {
    private final List<Cliente> clientes = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public Cliente crearCliente(Cliente cliente) {
        cliente.setId(counter.incrementAndGet());
        clientes.add(cliente);
        return cliente;
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }

    public Optional<Cliente> obtenerClientePorId(Long id) {
        return clientes.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public Cliente actualizarCliente(Long id, Cliente clienteDetalles) {
        Optional<Cliente> clienteOpt = obtenerClientePorId(id);
        if (clienteOpt.isPresent()) {
            Cliente cliente = clienteOpt.get();
            cliente.setNombre(clienteDetalles.getNombre());
            cliente.setCorreo(clienteDetalles.getCorreo());
            cliente.setTelefono(clienteDetalles.getTelefono());
            return cliente;
        }
        return null;
    }

    public boolean eliminarCliente(Long id) {
        return clientes.removeIf(cliente -> cliente.getId().equals(id));
    }
}
