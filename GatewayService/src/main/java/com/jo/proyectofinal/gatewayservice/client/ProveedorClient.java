package com.jo.proyectofinal.gatewayservice.client;

import com.jo.proyectofinal.common.entidad.Proveedor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "proveedor-service", url = "http://localhost:8094")
public interface ProveedorClient {

    @GetMapping("/proveedores")
    List<Proveedor> listarProveedores();
}
