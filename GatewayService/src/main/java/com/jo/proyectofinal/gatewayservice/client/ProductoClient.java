package com.jo.proyectofinal.gatewayservice.client;

import com.jo.proyectofinal.common.entidad.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "producto-service", url = "http://localhost:8098")
public interface ProductoClient {

    @GetMapping("/productos")
    List<Producto> listarProductos();
}
