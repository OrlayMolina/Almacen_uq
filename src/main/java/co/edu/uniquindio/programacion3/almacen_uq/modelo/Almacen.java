package co.edu.uniquindio.programacion3.almacen_uq.modelo;

import java.util.ArrayList;

public class Almacen {

    private ArrayList<ClienteNatural> listaClientesNaturales = new ArrayList<>();
    private ArrayList<ClienteJuridico> listaClientesJuridicos = new ArrayList<>();
    private ArrayList<ProductoEnvasado> listaproductosEnvasados = new ArrayList<>();

    //lista de productos refrigerados
    private ArrayList<ProductoRefrigerado> listaProductosRefrigerados = new ArrayList<>();

    public Almacen() {

    }

    public ClienteNatural crearClienteNatural(ClienteNatural clienteTemporal){
        ClienteNatural cliente = null; // OJO
        boolean bandera = false;

        if(bandera){
            //Exception
        } else {
            cliente = new ClienteNatural();
            cliente.setNombres(clienteTemporal.getNombres());
            cliente.setApellidos(clienteTemporal.getApellidos());
            cliente.setIdentificacion(clienteTemporal.getIdentificacion());
            cliente.setDireccion(clienteTemporal.getDireccion());
            cliente.setTelefono(clienteTemporal.getTelefono());
            cliente.setFechaNacimiento(clienteTemporal.getFechaNacimiento());
            cliente.setEmail(clienteTemporal.getEmail());

            getListaClientesNaturales().add(cliente);
        }

        return cliente;
    }

    public ClienteJuridico crearClienteJuridico(ClienteJuridico clienteTemporal){
        ClienteJuridico cliente = null; // OJO
        boolean bandera = false;

        if(bandera){
            //Exception
        } else {
            cliente = new ClienteJuridico();
            cliente.setNombres(clienteTemporal.getNombres());
            cliente.setApellidos(clienteTemporal.getApellidos());
            cliente.setIdentificacion(clienteTemporal.getIdentificacion());
            cliente.setDireccion(clienteTemporal.getDireccion());
            cliente.setTelefono(clienteTemporal.getTelefono());
            cliente.setNit(clienteTemporal.getNit());

            getListaClientesJuridicos().add(cliente);
        }

        return cliente;
    }

    public ProductoRefrigerado crearProductoRefrigerado(ProductoRefrigerado productoRefrigeradoTemporal){
        ProductoRefrigerado producto = null; // OJO
        boolean bandera = false;

        if(bandera){
            //Exception
        } else {
            producto = new ProductoRefrigerado();
            producto.setCodigo(productoRefrigeradoTemporal.getCodigo());
            producto.setNombreProducto(productoRefrigeradoTemporal.getNombreProducto());
            producto.setValorUnitario(productoRefrigeradoTemporal.getValorUnitario());
            producto.setCodigoAprobacion(productoRefrigeradoTemporal.getCodigoAprobacion());
            producto.setTemRefrigeracion(productoRefrigeradoTemporal.getTemRefrigeracion());


            getListaProductosRefrigerados().add(producto);
        }

        return producto;
    }

    public ProductoEnvasado crearProductoEnvasado(ProductoEnvasado envasadoTemporal){
        ProductoEnvasado envasado = null; // OJO
        boolean bandera = false;

        if(bandera){
            //Exception
        } else {
            envasado = new ProductoEnvasado();
            envasado.setCodigo(envasadoTemporal.getCodigo());
            envasado.setNombreProducto(envasadoTemporal.getNombreProducto());
            envasado.setDescripcion(envasadoTemporal.getDescripcion());
            envasado.setValorUnitario(envasadoTemporal.getValorUnitario());
            envasado.setExistencias(envasadoTemporal.getExistencias());
            envasado.setFechaEnvasado(envasadoTemporal.getFechaEnvasado());
            envasado.setPesoEnvase(envasadoTemporal.getPesoEnvase());
            envasado.setPais(envasadoTemporal.getPais());

            getListaProductosEnvasados().add(envasado);
        }

        return envasado;
    }

    public ArrayList<ClienteNatural> getListaClientesNaturales() {
        return listaClientesNaturales;
    }

    public ArrayList<ClienteJuridico> getListaClientesJuridicos() {
        return listaClientesJuridicos;
    }

    public ArrayList<ProductoRefrigerado> getListaProductosRefrigerados() {
        return listaProductosRefrigerados;
    }

    public ArrayList<ProductoEnvasado> getListaProductosEnvasados() {
        return listaproductosEnvasados;
    }

}
