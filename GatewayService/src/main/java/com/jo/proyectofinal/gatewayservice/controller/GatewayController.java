package com.jo.proyectofinal.gatewayservice.controller;

import com.jo.proyectofinal.common.entidad.Producto;
import com.jo.proyectofinal.gatewayservice.client.ProductoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gateway")
public class GatewayController {

    @Autowired
    private ProductoClient productoClient;

    @GetMapping("/productos")
    public List<Producto> listarProductos() {
        return productoClient.listarProductos();
    }
}


/*package com.jo.proyectofinal.gatewayservice.controller;

import com.jo.proyectofinal.common.entidad.Cliente;
import com.jo.proyectofinal.common.entidad.Proveedor;
import com.jo.proyectofinal.common.entidad.Factura;
import com.jo.proyectofinal.common.entidad.Empleado;
import com.jo.proyectofinal.common.entidad.Producto;
import com.jo.proyectofinal.gatewayservice.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gateway")
public class GatewayController {

    @Autowired
    private ProveedorClient proveedorClient;

    @Autowired
    private ClienteClient clienteClient;

    @Autowired
    private FacturaClient facturaClient;

    @Autowired
    private EmpleadoClient empleadoClient;

    @Autowired
    private ProductoClient productoClient;

    @GetMapping("/proveedores")
    public List<Proveedor> listarProveedores() {
        return proveedorClient.listarProveedores();
    }

    @GetMapping("/clientes")
    public List<Cliente> listarClientes() {
        return clienteClient.listarClientes();
    }

    @GetMapping("/facturas")
    public List<Factura> listarFacturas() {
        return facturaClient.listarFacturas();
    }

    @GetMapping("/empleados")
    public List<Empleado> listarEmpleados() {
        return empleadoClient.listarEmpleados();
    }

    @GetMapping("/productos")
    public List<Producto> listarProductos() {
        return productoClient.listarProductos();
    }
}*/
