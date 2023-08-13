package co.edu.uniquindio.programacion3.almacen_uq.subcontrolador;

import co.edu.uniquindio.programacion3.almacen_uq.factory.Factory;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.Almacen;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.ClienteNatural;

import java.util.ArrayList;

public class ClienteSubController {

    private Factory factory;
    private Almacen almacen;

    public ArrayList<ClienteNatural> obtenerClientes(){
        return factory.getListaClientesNaturales();
    }

    public ClienteSubController(Factory factory) {
        this.factory = factory;
        almacen = factory.getAlmacen();
    }

    public ClienteNatural crearCliente(ClienteNatural clienteTemporal) {
        return factory.crearClienteNatural(clienteTemporal);
    }

}
