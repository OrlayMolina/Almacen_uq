package co.edu.uniquindio.programacion3.almacen_uq.factory;

import co.edu.uniquindio.programacion3.almacen_uq.controlador.ClientesController;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.*;
import co.edu.uniquindio.programacion3.almacen_uq.persistencia.Persistencia;
import co.edu.uniquindio.programacion3.almacen_uq.subcontrolador.ClienteJuridicoSubController;

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
        cargarDatosJuridico();
        cargarDatosEnvasados();
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

    public void cargarDatosJuridico(){

        this.almacen = new Almacen();

        try{
            ArrayList<ClienteJuridico> cliente;
            cliente = persistencia.cargarClienteJuridico();
            getAlmacen().getListaClientesJuridicos().addAll(cliente);
        }catch(Exception e){
            e.printStackTrace(); // crear mensaje de error
        }
    }

    public void cargarDatosEnvasados(){

        this.almacen = new Almacen();

        try{
            ArrayList<ProductoEnvasado> envasado;
            envasado = persistencia.cargarEnvasados();
            getAlmacen().getListaProductosEnvasados().addAll(envasado);
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

    public ClienteJuridico crearClienteJuridico(ClienteJuridico clienteTemporal){
        ClienteJuridico cliente = null; // OJO
        try{
            cliente = getAlmacen().crearClienteJuridico(clienteTemporal);
            persistencia.guardarClienteJuridico(getListaClientesJuridicos());

        }catch(Exception e){
            e.printStackTrace(); //Crear exception
        }

        return cliente;
    }

    public ProductoEnvasado crearProductoEnvasado(ProductoEnvasado envasadoTemporal){
        ProductoEnvasado envasado = null; // OJO
        try{
            envasado = getAlmacen().crearProductoEnvasado(envasadoTemporal);
            persistencia.guardarProductosEnvasados(getListaProductosEnvasados());

        }catch(Exception e){
            e.printStackTrace(); //Crear exception
        }

        return envasado;
    }

    public ProductoRefrigerado crearProductoRefrigerado(ProductoRefrigerado refrigeradoTemporal){
        ProductoRefrigerado refrigerado = null; // OJO
        try{
            refrigerado = getAlmacen().crearProductoRefrigerado(refrigeradoTemporal);
            persistencia.guardarProductosRefrigerados(getListaProductosRefrigerados());

        }catch(Exception e){
            e.printStackTrace(); //Crear exception
        }

        return refrigerado;
    }

    public Almacen getAlmacen(){
        return almacen;
    }

    public ArrayList<ClienteNatural> getListaClientesNaturales() {
        return getAlmacen().getListaClientesNaturales();
    }

    public ArrayList<ClienteJuridico> getListaClientesJuridicos() {
        return getAlmacen().getListaClientesJuridicos();
    }

    public ArrayList<ProductoEnvasado> getListaProductosEnvasados() {
        return getAlmacen().getListaProductosEnvasados() ;
    }
    public ArrayList<ProductoRefrigerado> getListaProductosRefrigerados() {
        return getAlmacen().getListaProductosRefrigerados();
    }
}
