package co.edu.uniquindio.programacion3.almacen_uq.factory;

import co.edu.uniquindio.programacion3.almacen_uq.controlador.ClientesController;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.Almacen;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.ClienteNatural;
import co.edu.uniquindio.programacion3.almacen_uq.persistencia.Persistencia;

import java.io.IOException;
import java.util.ArrayList;

public class Factory {

    private Almacen almacen = new Almacen();
    private Persistencia persistencia = new Persistencia();
    private ClientesController controller = new ClientesController();

    public static class SingletonHolder {
        private final static Factory eINSTANCE = new Factory();
    }

    public static Factory getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public Factory(){
        cargarDatos();
    }


    public void cargarDatos(){

        this.almacen = new Almacen();

        try{
            ArrayList<ClienteNatural> cliente;
            cliente = persistencia.cargarCliente();
            getAlmacen().getListaClientesNaturales().addAll(cliente);
        }catch(Exception e){
            e.printStackTrace(); // crear mensaje de error
        }
    }

    public ClienteNatural crearClienteNatural(ClienteNatural clienteTemporal){
        ClienteNatural cliente = null; // OJO
        try{
            cliente = getAlmacen().crearClienteNatural(clienteTemporal);
            persistencia.guardarCliente(getListaClientesNaturales());

        }catch(Exception e){
            e.printStackTrace(); //Crear exception
        }

        return cliente;
    }

    public Almacen getAlmacen(){
        return almacen;
    }

    public ArrayList<ClienteNatural> getListaClientesNaturales() {
        return getAlmacen().getListaClientesNaturales();
    }
}