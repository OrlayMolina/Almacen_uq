package co.edu.uniquindio.programacion3.almacen_uq.modelo;

public class ProductoRefrigerado extends Producto{

    private String codigoHabilitacion;
    private String temRefrigeracion;

    public ProductoRefrigerado(){

    }

    public String getCodigoHabilitacion() {
        return codigoHabilitacion;
    }

    public void setCodigoHabilitacion(String codigoHabilitacion) {
        this.codigoHabilitacion = codigoHabilitacion;
    }

    public String getTemRefrigeracion() {
        return temRefrigeracion;
    }

    public void setTemRefrigeracion(String temRefrigeracion) {
        this.temRefrigeracion = temRefrigeracion;
    }
}
