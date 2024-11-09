package com.jo.proyectofinal.productoservice.impl;

import com.jo.proyectofinal.productoservice.entidad.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductoService {
    private final List<Producto> productos = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public Producto crearProducto(Producto producto) {
        producto.setId(counter.incrementAndGet());
        productos.add(producto);
        return producto;
    }

    public List<Producto> listarProductos() {
        return productos;
    }

    public Optional<Producto> obtenerProductoPorId(Long id) {
        return productos.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public Producto actualizarProducto(Long id, Producto productoDetalles) {
        Optional<Producto> productoOpt = obtenerProductoPorId(id);
        if (productoOpt.isPresent()) {
            Producto producto = productoOpt.get();
            producto.setNombre(productoDetalles.getNombre());
            producto.setPrecio(productoDetalles.getPrecio());
            producto.setStock(productoDetalles.getStock());
            return producto;
        }
        return null;
    }

    public boolean eliminarProducto(Long id) {
        return productos.removeIf(producto -> producto.getId().equals(id));
    }
}
