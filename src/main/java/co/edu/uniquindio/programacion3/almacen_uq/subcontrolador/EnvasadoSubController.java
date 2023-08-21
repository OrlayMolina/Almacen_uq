package co.edu.uniquindio.programacion3.almacen_uq.subcontrolador;

import co.edu.uniquindio.programacion3.almacen_uq.factory.Factory;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.Almacen;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.ClienteNatural;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.ProductoEnvasado;

import java.util.ArrayList;

public class EnvasadoSubController {

    private Factory factory;
    private Almacen almacen;

    public ArrayList<ProductoEnvasado> obtenerEnvasados(){
        return factory.getListaProductosEnvasados();
    }

    public EnvasadoSubController(){

    }

    public EnvasadoSubController(Factory factory) {
        this.factory = factory;
        almacen = factory.getAlmacen();
    }

    public void crearProductoEnvasado(ProductoEnvasado envasadoTemporal) {
         factory.crearProductoEnvasado(envasadoTemporal);
    }

    public boolean eliminarEnvasado(ProductoEnvasado envasado) {
        return factory.eliminarEnvasado(envasado);
    }

    public boolean actualizarEnvasado(ProductoEnvasado envasado) {
        return factory.actualizarEnvasado(envasado);
    }
}
