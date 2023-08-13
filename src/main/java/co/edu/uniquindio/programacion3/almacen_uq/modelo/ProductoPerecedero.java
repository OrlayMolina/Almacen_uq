package co.edu.uniquindio.programacion3.almacen_uq.modelo;

import java.time.LocalDate;

public class ProductoPerecedero extends Producto{

    private LocalDate fechaVencimiento;

    public ProductoPerecedero(){

    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}

