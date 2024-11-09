package com.jo.proyectofinal.proveedorservice.impl;

import com.jo.proyectofinal.proveedorservice.entidad.Proveedor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProveedorService {
    private final List<Proveedor> proveedores = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public Proveedor crearProveedor(Proveedor proveedor) {
        proveedor.setId(counter.incrementAndGet());
        proveedores.add(proveedor);
        return proveedor;
    }

    public List<Proveedor> listarProveedores() {
        return proveedores;
    }

    public Optional<Proveedor> obtenerProveedorPorId(Long id) {
        return proveedores.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public Proveedor actualizarProveedor(Long id, Proveedor proveedorDetalles) {
        Optional<Proveedor> proveedorOpt = obtenerProveedorPorId(id);
        if (proveedorOpt.isPresent()) {
            Proveedor proveedor = proveedorOpt.get();
            proveedor.setNombre(proveedorDetalles.getNombre());
            proveedor.setDireccion(proveedorDetalles.getDireccion());
            proveedor.setTelefono(proveedorDetalles.getTelefono());
            return proveedor;
        }
        return null;
    }

    public boolean eliminarProveedor(Long id) {
        return proveedores.removeIf(proveedor -> proveedor.getId().equals(id));
    }
}
