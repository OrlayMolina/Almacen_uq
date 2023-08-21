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
        cargarDatosRefrigerados();
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
            ArrayList<ClienteJuridico> juridico;
            juridico = persistencia.cargarClienteJuridico();
            getAlmacen().getListaClientesJuridicos().addAll(juridico);
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

    public void cargarDatosRefrigerados(){

        this.almacen = new Almacen();

        try{
            ArrayList<ProductoRefrigerado> refrigerado;
            refrigerado = persistencia.cargarRefrigerados();
            getAlmacen().getListaProductosRefrigerados().addAll(refrigerado);
        }catch(Exception e){
            e.printStackTrace(); // crear mensaje de error
        }
    }

    public ClienteNatural crearClienteNatural(ClienteNatural natural){
        ClienteNatural cliente = null; // OJO
        try{
            cliente = getAlmacen().crearClienteNatural(natural);
            persistencia.guardarCliente(getListaClientesNaturales());

        }catch(Exception e){
            e.printStackTrace(); //Crear exception
        }

        return cliente;
    }

    public ClienteJuridico crearClienteJuridico(ClienteJuridico clienteTemporal){
        ClienteJuridico juridico = null; // OJO
        try{
            juridico = getAlmacen().crearClienteJuridico(clienteTemporal);
            persistencia.guardarClienteJuridico(getListaClientesJuridicos());

        }catch(Exception e){
            e.printStackTrace(); //Crear exception
        }

        return juridico;
    }

    public void crearProductoEnvasado(ProductoEnvasado envasadoTemporal){
        ProductoEnvasado envasado = null; // OJO
        try{
            //envasado = getAlmacen().crearProductoEnvasado(envasadoTemporal);
            persistencia.guardarProductosEnvasados(getListaProductosEnvasados(), envasadoTemporal, 0);

        }catch(Exception e) {
            e.printStackTrace(); //Crear exception
        }
    }

    public ProductoRefrigerado crearRefrigerado(ProductoRefrigerado refrigeradoTemporal){
        ProductoRefrigerado refrigerado = null; // OJO
        try{
            refrigerado = getAlmacen().crearProductoRefrigerado(refrigeradoTemporal);
            persistencia.guardarProductosRefrigerados(getListaProductosRefrigerados());

        }catch(Exception e){
            e.printStackTrace(); //Crear exception
        }

        return refrigerado;
    }

    public VentaDetalle crearDetalles(VentaDetalle detalleTemporal){
        VentaDetalle detalle = null; // OJO
        try{
            detalle = getAlmacen().crearDetalles(detalleTemporal);
            persistencia.guardarVentaDetalle(getListaVentaDetalles());

        }catch(Exception e){
            e.printStackTrace(); //Crear exception
        }

        return detalle;
    }

    public boolean eliminarCliente(ClienteNatural clienteNatural) {
        boolean bandera = false;

        try{
            bandera = getAlmacen().eliminarCliente(clienteNatural);
            persistencia.guardarCliente(getListaClientesNaturales());
            //persistencia.guardarArchivoLogEnvasados("Se ha eliminado el Cliente correctamente",1,"Dispositivo se ha eliminado con éxito");
        }catch(IOException e){
            System.out.println("Ha ocurrido un error de archivo.");
        }

        return bandera;
    }

    public boolean eliminarEnvasado(ProductoEnvasado envasado) {

        boolean bandera = false;

        try{
            //bandera = getAlmacen().eliminarEnvasado(envasado);
            persistencia.guardarProductosEnvasados(getListaProductosEnvasados(),envasado, 1);
            return  true;
            //persistencia.guardarArchivoLogEnvasados("Se ha eliminado el Producto Envasado correctamente",1,"Dispositivo se ha eliminado con éxito");
        }catch(IOException e){
            System.out.println("Ha ocurrido un error de archivo.");
        }

        return bandera;
    }

    public boolean eliminarRefrigerado(ProductoRefrigerado refrigerado) {
        boolean bandera = false;

        try{
            bandera = getAlmacen().eliminarRefrigerado(refrigerado);
            persistencia.guardarProductosRefrigerados(getListaProductosRefrigerados());
            //persistencia.guardarArchivoLogEnvasados("Se ha eliminado el Producto Envasado correctamente",1,"Dispositivo se ha eliminado con éxito");
        }catch(IOException e){
            System.out.println("Ha ocurrido un error de archivo.");
        }

        return bandera;
    }

    public boolean actualizarEnvasado(ProductoEnvasado envasado) {
        boolean bandera = false;

        try{

            persistencia.guardarProductosEnvasados(getListaProductosEnvasados(), envasado, 2);
            //persistencia.guardarArchivoLog("Se ha actualizado un producto",1,"Dispositivo se ha actualizado con éxito");
        }catch(IOException e){
            System.out.println("Ha ocurrido un error de archivo.");
        }

        return bandera;
    }

    public boolean actualizarRefrigerado(ProductoRefrigerado refrigerado) {
        boolean bandera = false;

        try{
            bandera = getAlmacen().actualizarRefrigerado(refrigerado);
            persistencia.guardarProductosRefrigerados(getListaProductosRefrigerados());
            //persistencia.guardarArchivoLog("Se ha actualizado un producto",1,"Dispositivo se ha actualizado con éxito");
        }catch(IOException e){
            System.out.println("Ha ocurrido un error de archivo.");
        }

        return bandera;
    }

    public boolean actualizarCliente(ClienteNatural natural) {
        boolean bandera = false;

        try{
            bandera = getAlmacen().actualizarCliente(natural);
            persistencia.guardarCliente(getListaClientesNaturales());
            //persistencia.guardarArchivoLog("Se ha actualizado un cliente",1,"Cliente se ha actualizado con éxito");
        }catch(IOException e){
            System.out.println("Ha ocurrido un error de archivo.");
        }

        return bandera;
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
        return getAlmacen().getListaProductosRefrigerados() ;
    }

    public ArrayList<VentaDetalle> getListaVentaDetalles() {
        return getAlmacen().getListaVentaDetalles();
    }
}
