package co.edu.uniquindio.programacion3.almacen_uq.subcontrolador;

import co.edu.uniquindio.programacion3.almacen_uq.factory.Factory;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.Almacen;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.ClienteNatural;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.Venta;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.VentaDetalle;

import java.util.ArrayList;

public class VentaDetallesSubController {

    private Factory factory;
    private Almacen almacen;

    public ArrayList<VentaDetalle> obtenerDetalles(){
        return factory.getListaVentaDetalles();
    }

    public VentaDetallesSubController(Factory factory) {
        this.factory = factory;
        almacen = factory.getAlmacen();
    }

    public VentaDetalle crearDetalles(VentaDetalle detalle) {
        return factory.crearDetalles(detalle);
    }
}
