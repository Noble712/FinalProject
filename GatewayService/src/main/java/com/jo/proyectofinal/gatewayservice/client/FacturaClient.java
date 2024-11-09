package com.jo.proyectofinal.gatewayservice.client;

import com.jo.proyectofinal.common.entidad.Factura;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "factura-service", url = "http://localhost:8096")
public interface FacturaClient {

    @GetMapping("/facturas")
    List<Factura> listarFacturas();
}

