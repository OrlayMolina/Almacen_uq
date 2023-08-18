package co.edu.uniquindio.programacion3.almacen_uq.modelo;

public class VentaDetalle {

    private int cantidad;

    private double subtotal;

    private Producto producto;

    public VentaDetalle(){

    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
