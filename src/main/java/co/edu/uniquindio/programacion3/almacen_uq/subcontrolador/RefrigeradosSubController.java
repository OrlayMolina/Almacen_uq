package co.edu.uniquindio.programacion3.almacen_uq.subcontrolador;

import co.edu.uniquindio.programacion3.almacen_uq.factory.Factory;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.Almacen;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.ProductoRefrigerado;

import java.util.ArrayList;

public class RefrigeradosSubController {

    private Factory factory;
    private Almacen almacen;

    public ArrayList<ProductoRefrigerado> obtenerRefrigerados(){
        return factory.getListaProductosRefrigerados();
    }

    public RefrigeradosSubController(){

    }

    public RefrigeradosSubController(Factory factory) {
        this.factory = factory;
        almacen = factory.getAlmacen();
    }

    public void crearRefrigerado(ProductoRefrigerado refrigeradoTemporal) {
        factory.crearRefrigerado(refrigeradoTemporal);
    }

    public boolean eliminarRefrigerado(ProductoRefrigerado refrigerado) {
        return factory.eliminarRefrigerado(refrigerado);
    }

    public boolean actualizarRefrigerado(ProductoRefrigerado refrigerado) {
        return factory.actualizarRefrigerado(refrigerado);
    }

}
