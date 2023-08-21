package co.edu.uniquindio.programacion3.almacen_uq.subcontrolador;

import co.edu.uniquindio.programacion3.almacen_uq.factory.Factory;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.Almacen;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.Cliente;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.ClienteNatural;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.ProductoEnvasado;

import java.util.ArrayList;

public class ClienteSubController {

    private Factory factory;
    private Almacen almacen;

    public ArrayList<ClienteNatural> obtenerClientes(){
        return factory.getListaClientesNaturales();
    }

    public ClienteSubController() {

    }

    public ClienteSubController(Factory factory) {
        this.factory = factory;
        almacen = factory.getAlmacen();
    }

    public ClienteNatural crearCliente(ClienteNatural natural) {
        return factory.crearClienteNatural(natural);
    }

    public boolean eliminarCliente(ClienteNatural natural) {
        return factory.eliminarCliente(natural);
    }

    public boolean actualizarCliente(ClienteNatural natural) {
        return factory.actualizarCliente(natural);
    }

}