package com.jo.proyectofinal.productoservice.controller;

import com.jo.proyectofinal.productoservice.entidad.Producto;
import com.jo.proyectofinal.productoservice.impl.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.crearProducto(producto);
    }

    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }

    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable Long id) {
        return productoService.obtenerProductoPorId(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto productoDetalles) {
        return productoService.actualizarProducto(id, productoDetalles);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
    }
}

