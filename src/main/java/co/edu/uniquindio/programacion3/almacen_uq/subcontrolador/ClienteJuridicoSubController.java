package co.edu.uniquindio.programacion3.almacen_uq.subcontrolador;

import co.edu.uniquindio.programacion3.almacen_uq.factory.Factory;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.Almacen;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.ClienteJuridico;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.ClienteNatural;

import java.util.ArrayList;

public class ClienteJuridicoSubController {

    private Factory factory;
    private Almacen almacen;

    public ArrayList<ClienteJuridico> obtenerClientesJuridicos(){
        return factory.getListaClientesJuridicos();
    }

    public ClienteJuridicoSubController(Factory factory) {
        this.factory = factory;
        almacen = factory.getAlmacen();
    }

    public ClienteJuridico crearClienteJuridico(ClienteJuridico clienteTemporal) {
        return factory.crearClienteJuridico(clienteTemporal);
    }
}