package com.jo.proyectofinal.proveedorservice.controller;

import com.jo.proyectofinal.proveedorservice.entidad.Proveedor;
import com.jo.proyectofinal.proveedorservice.impl.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @PostMapping
    public Proveedor crearProveedor(@RequestBody Proveedor proveedor) {
        return proveedorService.crearProveedor(proveedor);
    }

    @GetMapping
    public List<Proveedor> listarProveedores() {
        return proveedorService.listarProveedores();
    }

    @GetMapping("/{id}")
    public Proveedor obtenerProveedorPorId(@PathVariable Long id) {
        return proveedorService.obtenerProveedorPorId(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Proveedor actualizarProveedor(@PathVariable Long id, @RequestBody Proveedor proveedorDetalles) {
        return proveedorService.actualizarProveedor(id, proveedorDetalles);
    }

    @DeleteMapping("/{id}")
    public void eliminarProveedor(@PathVariable Long id) {
        proveedorService.eliminarProveedor(id);
    }
}
