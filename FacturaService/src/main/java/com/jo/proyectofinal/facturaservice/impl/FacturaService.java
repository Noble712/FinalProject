package com.jo.proyectofinal.facturaservice.impl;

import com.jo.proyectofinal.facturaservice.entidad.Factura;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class FacturaService {
    private final List<Factura> facturas = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public Factura crearFactura(Factura factura) {
        factura.setId(counter.incrementAndGet());
        facturas.add(factura);
        return factura;
    }

    public List<Factura> listarFacturas() {
        return facturas;
    }

    public Optional<Factura> obtenerFacturaPorId(Long id) {
        return facturas.stream().filter(f -> f.getId().equals(id)).findFirst();
    }

    public Factura actualizarFactura(Long id, Factura facturaDetalles) {
        Optional<Factura> facturaOpt = obtenerFacturaPorId(id);
        if (facturaOpt.isPresent()) {
            Factura factura = facturaOpt.get();
            factura.setClienteId(facturaDetalles.getClienteId());
            factura.setMonto(facturaDetalles.getMonto());
            factura.setFecha(facturaDetalles.getFecha());
            return factura;
        }
        return null;
    }

    public boolean eliminarFactura(Long id) {
        return facturas.removeIf(factura -> factura.getId().equals(id));
    }
}

