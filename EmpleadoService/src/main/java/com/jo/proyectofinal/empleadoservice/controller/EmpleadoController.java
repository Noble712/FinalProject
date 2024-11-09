package com.jo.proyectofinal.empleadoservice.controller;

import com.jo.proyectofinal.empleadoservice.entidad.Empleado;
import com.jo.proyectofinal.empleadoservice.impl.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping
    public Empleado crearEmpleado(@RequestBody Empleado empleado) {
        return empleadoService.crearEmpleado(empleado);
    }

    @GetMapping
    public List<Empleado> listarEmpleados() {
        return empleadoService.listarEmpleados();
    }

    @GetMapping("/{id}")
    public Empleado obtenerEmpleadoPorId(@PathVariable Long id) {
        return empleadoService.obtenerEmpleadoPorId(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Empleado actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado empleadoDetalles) {
        return empleadoService.actualizarEmpleado(id, empleadoDetalles);
    }

    @DeleteMapping("/{id}")
    public void eliminarEmpleado(@PathVariable Long id) {
        empleadoService.eliminarEmpleado(id);
    }
}

