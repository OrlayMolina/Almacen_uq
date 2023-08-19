package co.edu.uniquindio.programacion3.almacen_uq.modelo;

public class ProductoRefrigerado extends Producto{

    private String codigoAprobacion;
    private String temRefrigeracion;

    public ProductoRefrigerado(){

    }

    public String getCodigoAprobacion() {
        return codigoAprobacion;
    }

    public void setCodigoAprobacion(String codigoHabilitacion) {
        this.codigoAprobacion = codigoHabilitacion;
    }

    public String getTemRefrigeracion() {
        return temRefrigeracion;
    }

    public void setTemRefrigeracion(String temRefrigeracion) {
        this.temRefrigeracion = temRefrigeracion;
    }
}
