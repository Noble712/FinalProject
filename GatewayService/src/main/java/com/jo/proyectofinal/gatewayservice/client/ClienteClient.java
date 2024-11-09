package com.jo.proyectofinal.gatewayservice.client;

import com.jo.proyectofinal.common.entidad.Cliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "cliente-service", url = "http://localhost:8095")
public interface ClienteClient {

    @GetMapping("/clientes")
    List<Cliente> listarClientes();
}
