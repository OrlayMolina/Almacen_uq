package co.edu.uniquindio.programacion3.almacen_uq.subcontrolador;

import co.edu.uniquindio.programacion3.almacen_uq.factory.Factory;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.Almacen;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.ProductoEnvasado;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.ProductoPerecedero;

import java.util.ArrayList;

public class PerecederoSubController {



    private Factory factory;
    private Almacen almacen;

    public ArrayList<ProductoPerecedero> obtenerPerecedero(){
        return factory.getListaProductosPerecederos();
    }

    public PerecederoSubController(){

    }

    public PerecederoSubController(Factory factory) {
        this.factory = factory;
        almacen = factory.getAlmacen();
    }

    public void crearProductoPerecedero(ProductoPerecedero perecedero) {
        factory.crearProductoPerecedero(perecedero);
    }

    public boolean eliminarPerecedero(ProductoPerecedero perecedero) {
        return factory.eliminarPerecedero(perecedero);
    }

    public boolean actualizarPerecedero(ProductoPerecedero perecedero) {
        return factory.actualizarPerecedero(perecedero);
    }
}
