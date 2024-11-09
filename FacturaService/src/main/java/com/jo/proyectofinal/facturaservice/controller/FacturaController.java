package com.jo.proyectofinal.facturaservice.controller;

import com.jo.proyectofinal.facturaservice.entidad.Factura;
import com.jo.proyectofinal.facturaservice.impl.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @PostMapping
    public Factura crearFactura(@RequestBody Factura factura) {
        return facturaService.crearFactura(factura);
    }

    @GetMapping
    public List<Factura> listarFacturas() {
        return facturaService.listarFacturas();
    }

    @GetMapping("/{id}")
    public Factura obtenerFacturaPorId(@PathVariable Long id) {
        return facturaService.obtenerFacturaPorId(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Factura actualizarFactura(@PathVariable Long id, @RequestBody Factura facturaDetalles) {
        return facturaService.actualizarFactura(id, facturaDetalles);
    }

    @DeleteMapping("/{id}")
    public void eliminarFactura(@PathVariable Long id) {
        facturaService.eliminarFactura(id);
    }
}

