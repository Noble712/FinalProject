package com.jo.proyectofinal.gatewayservice.client;

import com.jo.proyectofinal.common.entidad.Empleado;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "empleado-service", url = "http://localhost:8097")
public interface EmpleadoClient {

    @GetMapping("/empleados")
    List<Empleado> listarEmpleados();
}
