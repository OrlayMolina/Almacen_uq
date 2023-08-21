package co.edu.uniquindio.programacion3.almacen_uq.modelo;

import co.edu.uniquindio.programacion3.almacen_uq.excepciones.ProductoExisteException;
import co.edu.uniquindio.programacion3.almacen_uq.persistencia.Persistencia;

import java.util.ArrayList;

public class Almacen {

    private ArrayList<ClienteNatural> listaClientesNaturales = new ArrayList<>();
    private ArrayList<ClienteJuridico> listaClientesJuridicos = new ArrayList<>();
    private ArrayList<ProductoEnvasado> listaproductosEnvasados = new ArrayList<>();
    private ArrayList<VentaDetalle> listaVentaDetalle = new ArrayList<>();
    //lista de productos refrigerados
    private ArrayList<ProductoRefrigerado> listaProductosRefrigerados = new ArrayList<>();
    private Persistencia persistencia;


    public Almacen() {
        this.persistencia = new Persistencia();
    }

    public boolean validarPorCodigo(ProductoEnvasado envasado){

        for (ProductoEnvasado p : listaproductosEnvasados) {
            if (p.getCodigo().equals(envasado.getCodigo())) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarSiExiste(ProductoEnvasado envasado) throws ProductoExisteException {
        if(validarPorCodigo(envasado)){
            throw new ProductoExisteException();
        }
        return false;
    }

    public ClienteNatural crearClienteNatural(Cliente natural){
        ClienteNatural cliente = null; // OJO
        boolean bandera = false;

        if(bandera){
            //Exception
        } else {
            cliente = new ClienteNatural();
            cliente.setNombres(cliente.getNombres());
            cliente.setApellidos(cliente.getApellidos());
            cliente.setIdentificacion(cliente.getIdentificacion());
            cliente.setDireccion(cliente.getDireccion());
            cliente.setTelefono(cliente.getTelefono());
            cliente.setFechaNacimiento(cliente.getFechaNacimiento());
            cliente.setEmail(cliente.getEmail());

            //getListaClientesNaturales().add(cliente);
        }

        return cliente;
    }

    public ClienteJuridico crearClienteJuridico(ClienteJuridico clienteTemporal){
        ClienteJuridico juridico = null; // OJO
        boolean bandera = false;

        if(bandera){
            //Exception
        } else {
            juridico = new ClienteJuridico();
            juridico.setNombres(clienteTemporal.getNombres());
            juridico.setApellidos(clienteTemporal.getApellidos());
            juridico.setIdentificacion(clienteTemporal.getIdentificacion());
            juridico.setDireccion(clienteTemporal.getDireccion());
            juridico.setTelefono(clienteTemporal.getTelefono());
            juridico.setNit(clienteTemporal.getNit());

            getListaClientesJuridicos().add(juridico);
        }

        return juridico;
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
            producto.setDescripcion(productoRefrigeradoTemporal.getDescripcion());
            producto.setExistencias(productoRefrigeradoTemporal.getExistencias());


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

            //listaproductosEnvasados.add(envasado);
            //getListaProductosEnvasados().add(envasado);
        }

        return envasado;
    }

    public VentaDetalle crearDetalles(VentaDetalle detalleTemporal){
        VentaDetalle detalle = null; // OJO
        boolean bandera = false;

        if(bandera){
            //Exception
        } else {
            detalle = new VentaDetalle();
            detalle.setCodigoVenta(detalleTemporal.getCodigoVenta());
            detalle.setCantidad(detalleTemporal.getCantidad());
            detalle.setSubtotal(detalleTemporal.getSubtotal());
            detalle.setProducto(detalleTemporal.getProducto());

            getListaVentaDetalles().add(detalle);
        }

        return detalle;
    }

    /*public boolean eliminarCliente(ClienteNatural ClienteNatural) {
        boolean bandera = false;

        if(ClienteNatural != null) {
            getListaClientesNaturales().remove(ClienteNatural);
            bandera = true;
        }else {
            System.out.println("Cliente no existe");
        }
        return bandera;
    }*/

    /*public boolean eliminarEnvasado(ProductoEnvasado envasado) {
        boolean bandera = false;

        if(envasado != null) {
            getListaProductosEnvasados().remove(envasado);
            bandera = true;
        }else {
            System.out.println("Procesamiento no existe");
        }
        return bandera;
    }*/

    public boolean eliminarRefrigerado(ProductoRefrigerado refrigerado) {
        boolean bandera = false;

        if(refrigerado != null) {
            getListaProductosRefrigerados().remove(refrigerado);
            bandera = true;
        }else {
            System.out.println("Procesamiento no existe");
        }
        return bandera;
    }

    public boolean actualizarCliente(ClienteNatural natural) {
        ClienteNatural actualizado = new ClienteNatural();
        boolean bandera = false;

        if(natural != null) {
            for(int i = 0; i < getListaClientesNaturales().size(); i++){
                if(getListaClientesNaturales().get(i).getIdentificacion().equals(natural.getIdentificacion())){
                    actualizado.setNombres(natural.getNombres());
                    actualizado.setApellidos(natural.getApellidos());
                    actualizado.setIdentificacion(natural.getIdentificacion());
                    actualizado.setDireccion(natural.getDireccion());
                    actualizado.setTelefono(natural.getTelefono());
                    actualizado.setEmail(natural.getEmail());
                    actualizado.setFechaNacimiento(natural.getFechaNacimiento());

                    getListaClientesNaturales().set(i, actualizado);
                    bandera = true;
                }


            }
        }else {
            System.out.println("Producto no existe");
        }
        return bandera;
    }

    public boolean actualizarEnvasado(ProductoEnvasado envasado) {
        ProductoEnvasado actualizado = new ProductoEnvasado();
        boolean bandera = false;

        if(envasado != null) {
            for(int i = 0; i < getListaProductosEnvasados().size(); i++){
                if(getListaProductosEnvasados().get(i).getCodigo().equals(envasado.getCodigo())){
                    actualizado.setCodigo(envasado.getCodigo());
                    actualizado.setNombreProducto(envasado.getNombreProducto());
                    actualizado.setDescripcion(envasado.getDescripcion());
                    actualizado.setValorUnitario(envasado.getValorUnitario());
                    actualizado.setExistencias(envasado.getExistencias());
                    actualizado.setFechaEnvasado(envasado.getFechaEnvasado());
                    actualizado.setPesoEnvase(envasado.getPesoEnvase());
                    actualizado.setPais(envasado.getPais());

                    getListaProductosEnvasados().set(i, actualizado);
                    bandera = true;
                }


            }
        }else {
            System.out.println("Producto no existe");
        }
        return bandera;
    }

    public boolean actualizarRefrigerado(ProductoRefrigerado refrigerado) {
        ProductoRefrigerado actualizado = new ProductoRefrigerado();
        boolean bandera = false;

        if(refrigerado != null) {
            for(int i = 0; i < getListaProductosRefrigerados().size(); i++){
                if(getListaProductosRefrigerados().get(i).getCodigo().equals(refrigerado.getCodigo())){
                    actualizado.setCodigo(refrigerado.getCodigo());
                    actualizado.setNombreProducto(refrigerado.getNombreProducto());
                    actualizado.setValorUnitario(refrigerado.getValorUnitario());
                    actualizado.setCodigoAprobacion(refrigerado.getCodigoAprobacion());
                    actualizado.setTemRefrigeracion(refrigerado.getTemRefrigeracion());
                    actualizado.setDescripcion(refrigerado.getDescripcion());
                    actualizado.setExistencias(refrigerado.getExistencias());


                    getListaProductosRefrigerados().set(i, actualizado);
                    bandera = true;
                }


            }
        }else {
            System.out.println("Producto no existe");
        }
        return bandera;
    }

    public ArrayList<ClienteNatural> getListaClientesNaturales() {
        return persistencia.cargarCliente();
    }

    public ArrayList<ClienteJuridico> getListaClientesJuridicos() {
        return listaClientesJuridicos;
    }

    public ArrayList<ProductoRefrigerado> getListaProductosRefrigerados() {
        return listaProductosRefrigerados;
    }

    public ArrayList<ProductoEnvasado> getListaProductosEnvasados() {
        return persistencia.cargarEnvasados();
    }

    public ArrayList<VentaDetalle> getListaVentaDetalles() {
        return listaVentaDetalle;
    }

}
