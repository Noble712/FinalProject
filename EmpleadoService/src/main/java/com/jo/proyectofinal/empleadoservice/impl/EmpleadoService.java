package com.jo.proyectofinal.empleadoservice.impl;

import com.jo.proyectofinal.empleadoservice.entidad.Empleado;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class EmpleadoService {
    private final List<Empleado> empleados = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public Empleado crearEmpleado(Empleado empleado) {
        empleado.setId(counter.incrementAndGet());
        empleados.add(empleado);
        return empleado;
    }

    public List<Empleado> listarEmpleados() {
        return empleados;
    }

    public Optional<Empleado> obtenerEmpleadoPorId(Long id) {
        return empleados.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    public Empleado actualizarEmpleado(Long id, Empleado empleadoDetalles) {
        Optional<Empleado> empleadoOpt = obtenerEmpleadoPorId(id);
        if (empleadoOpt.isPresent()) {
            Empleado empleado = empleadoOpt.get();
            empleado.setNombre(empleadoDetalles.getNombre());
            empleado.setPuesto(empleadoDetalles.getPuesto());
            empleado.setSalario(empleadoDetalles.getSalario());
            return empleado;
        }
        return null;
    }

    public boolean eliminarEmpleado(Long id) {
        return empleados.removeIf(empleado -> empleado.getId().equals(id));
    }
}
