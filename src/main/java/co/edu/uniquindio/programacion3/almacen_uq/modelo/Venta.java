package co.edu.uniquindio.programacion3.almacen_uq.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Venta {

    private ArrayList<VentaDetalle> listaVentaDetalles = new ArrayList<>();

    private String codigo;

    private LocalDate fecha;

    private Cliente cliente;

    private double total;

    private double iva;

    public Venta(){

    }

    public ArrayList<VentaDetalle> getListaVentaDetalles() {
        return listaVentaDetalles;
    }

    public void setListaVentaDetalles(ArrayList<VentaDetalle> listaVentaDetalles) {
        this.listaVentaDetalles = listaVentaDetalles;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }
}
