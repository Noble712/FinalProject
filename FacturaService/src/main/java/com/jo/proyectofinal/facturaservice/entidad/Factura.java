package com.jo.proyectofinal.facturaservice.entidad;

import java.util.Date;

public class Factura {
    private Long id;
    private Long clienteId;
    private Double monto;
    private Date fecha;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
    public Double getMonto() { return monto; }
    public void setMonto(Double monto) { this.monto = monto; }
    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
}

