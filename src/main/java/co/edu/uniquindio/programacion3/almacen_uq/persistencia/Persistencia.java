package co.edu.uniquindio.programacion3.almacen_uq.persistencia;

import co.edu.uniquindio.programacion3.almacen_uq.enumm.Pais;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Persistencia {

    public ArchivoUtil archivoUtil = new ArchivoUtil();

    // OJO, tener el cuenta cambiar la ruta donde se almacenan los archivos.


    public static final String rutaArchivos = "C:\\Users\\Orlay.molina\\programacion3\\almacen\\src\\main\\java\\co\\edu\\uniquindio\\programacion3\\almacen_uq\\archivos\\Cliente.txt";

    public static final String rutaLog = "C:\\Users\\Orlay.molina\\programacion3\\almacen\\src\\main\\java\\co\\edu\\uniquindio\\programacion3\\almacen_uq\\archivos\\ClienteLog.txt";

    public static final String rutaJuridico = "C:\\Users\\Orlay.molina\\programacion3\\almacen\\src\\main\\java\\co\\edu\\uniquindio\\programacion3\\almacen_uq\\archivos\\ClienteJuridico.txt";

    public static final String rutaLogClienteJuridico = "C:\\Users\\Orlay.molina\\programacion3\\almacen\\src\\main\\java\\co\\edu\\uniquindio\\programacion3\\almacen_uq\\archivos\\ClienteJuridicoLog.txt";

    public static final String rutaEnvasados = "C:\\Users\\Orlay.molina\\programacion3\\almacen\\src\\main\\java\\co\\edu\\uniquindio\\programacion3\\almacen_uq\\archivos\\Envasados.txt";

    public static final String rutaLogEnvasados = "C:\\Users\\Orlay.molina\\programacion3\\almacen\\src\\main\\java\\co\\edu\\uniquindio\\programacion3\\almacen_uq\\archivos\\EnvasadosLog.txt";

    public static final String rutaRefrigerados = "C:\\Users\\Orlay.molina\\programacion3\\almacen\\src\\main\\java\\co\\edu\\uniquindio\\programacion3\\almacen_uq\\archivos\\Refrigerados.txt";

    public static final String rutaLogRefrigerados = "C:\\Users\\Orlay.molina\\programacion3\\almacen\\src\\ main\\java\\co\\edu\\uniquindio\\programacion3\\almacen_uq\\archivos\\RefrigeradosLog.txt";

    public static final String rutaVentaDetalle = "C:\\Users\\Orlay.molina\\programacion3\\almacen\\src\\main\\java\\co\\edu\\uniquindio\\programacion3\\almacen_uq\\archivos\\VentaDetalle.txt";

    public static final String rutaLogVentaDetalle = "C:\\Users\\Orlay.molina\\programacion3\\almacen\\src\\ main\\java\\co\\edu\\uniquindio\\programacion3\\almacen_uq\\archivos\\VentaDetalleLog.txt";

    public void guardarArchivoLog(String mensajeLog, int nivel, String accion) {
        archivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, rutaLog);
    }

    public void guardarArchivoLogJuridico(String mensajeLog, int nivel, String accion) {
        archivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, rutaLogClienteJuridico);
    }

    public void guardarArchivoLogEnvasados(String mensajeLog, int nivel, String accion) {
        archivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, rutaLogEnvasados);
    }

    public void guardarArchivoLogRefrigerados(String mensajeLog, int nivel, String accion) {
        archivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, rutaLogRefrigerados);
    }

    public void guardarArchivoLogVentaDetalle(String mensajeLog, int nivel, String accion) {
        archivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, rutaLogVentaDetalle);
    }

    public void guardarCliente(ArrayList<ClienteNatural> listaClientesNaturales) throws IOException {
        StringBuilder contenido = new StringBuilder();
        for (ClienteNatural n : listaClientesNaturales) {
            contenido.append(n.getNombres()).append("--").
                    append(n.getApellidos()).append("--").
                    append(n.getIdentificacion()).append("--").
                    append(n.getDireccion()).append("--").
                    append(n.getTelefono()).append("--").
                    append(n.getFechaNacimiento()).append("--").
                    append(n.getEmail()).append("\n");

            archivoUtil.guardarArchivo(rutaArchivos, contenido.toString(), false);
        }
    }

    public void guardarVentaDetalle(ArrayList<VentaDetalle> listaVentaDetalle) throws IOException {
        StringBuilder contenido = new StringBuilder();
        for (VentaDetalle d : listaVentaDetalle) {
            contenido.append(d.getCodigoVenta()).append("--").
                    append(d.getCantidad()).append("--").
                    append(d.getSubtotal()).append("--").
                    append(d.getProducto()).append("\n");

            archivoUtil.guardarArchivo(rutaVentaDetalle, contenido.toString(), false);
        }
    }

    public void guardarClienteJuridico(ArrayList<ClienteJuridico> listaClientesJuridico) throws IOException {
        StringBuilder contenido = new StringBuilder();
        for (ClienteJuridico j : listaClientesJuridico) {
            contenido.append(j.getNombres()).append("--").
                    append(j.getApellidos()).append("--").
                    append(j.getIdentificacion()).append("--").
                    append(j.getDireccion()).append("--").
                    append(j.getTelefono()).append("--").
                    append(j.getNit()).append("\n");

            archivoUtil.guardarArchivo(rutaJuridico, contenido.toString(), false);
        }
    }

    /**
     * @param accion 0 = crear, 1 = elimar
     * @param listaProductosEnvasados
     * @param productoEnvasado
     * @throws IOException
     */

    public void guardarProductosEnvasados(ArrayList<ProductoEnvasado> listaProductosEnvasados, ProductoEnvasado productoEnvasado, int accion) throws IOException {
        StringBuilder contenido = new StringBuilder();
        if(accion == 0) {
            listaProductosEnvasados.add(productoEnvasado);
        }else if (accion == 1) {
            listaProductosEnvasados.removeIf(p -> p.getCodigo().equals(productoEnvasado.getCodigo()));
        }else {
            actualizarProductoEnvasado(listaProductosEnvasados, productoEnvasado);
        }

        for (ProductoEnvasado e : listaProductosEnvasados) {
            contenido.append(e.getCodigo()).append("--").
                    append(e.getNombreProducto()).append("--").
                    append(e.getDescripcion()).append("--").
                    append(e.getValorUnitario()).append("--").
                    append(e.getExistencias()).append("--").
                    append(e.getFechaEnvasado()).append("--").
                    append(e.getPesoEnvase()).append("--").
                    append(e.getPais()).append("\n");


        }
        archivoUtil.guardarArchivo(rutaEnvasados, contenido.toString(), false);
    }

    /**
     * Método para actualizar el producto envasado
     * @param listaProductosEnvasados
     * @param productoEnvasado producto a modificar
     */
    private void actualizarProductoEnvasado (ArrayList<ProductoEnvasado> listaProductosEnvasados, ProductoEnvasado productoEnvasado){
        for (ProductoEnvasado e : listaProductosEnvasados) {
            if(e.getCodigo().equals(productoEnvasado.getCodigo())){
                e.setFechaEnvasado(productoEnvasado.getFechaEnvasado());
                e.setNombreProducto(productoEnvasado.getNombreProducto());
                e.setExistencias(productoEnvasado.getExistencias());
                e.setPesoEnvase(productoEnvasado.getPesoEnvase());
                e.setDescripcion(productoEnvasado.getDescripcion());
                e.setPais(productoEnvasado.getPais());
                e.setValorUnitario(productoEnvasado.getValorUnitario());
            }
        }
    }

    public void guardarProductosRefrigerados(ArrayList<ProductoRefrigerado> listaProductosRefrigerados) throws IOException {
        StringBuilder contenido = new StringBuilder();
        for (ProductoRefrigerado e : listaProductosRefrigerados) {
            contenido.append(e.getCodigo()).append("--").
                    append(e.getNombreProducto()).append("--").
                    append(e.getValorUnitario()).append("--").
                    append(e.getCodigoAprobacion()).append("--").
                    append(e.getTemRefrigeracion()).append("--").
                    append(e.getDescripcion()).append("--").
                    append(e.getExistencias()).append("\n");

            archivoUtil.guardarArchivo(rutaRefrigerados, contenido.toString(), false);
        }
    }


    public ArrayList<ClienteNatural> cargarCliente() {
        ArrayList<ClienteNatural> clientes = new ArrayList<>();
        ArrayList<String> contenido = null;
        try {
            contenido = archivoUtil.leerArchivo(rutaArchivos);
            String linea; // OJO

            for (String c : contenido) {
                linea = c;
                ClienteNatural clienteNatural = new ClienteNatural();

                clienteNatural.setNombres(linea.split("--")[0]);
                clienteNatural.setApellidos(linea.split("--")[1]);
                clienteNatural.setIdentificacion(linea.split("--")[2]);
                clienteNatural.setDireccion(linea.split("--")[3]);
                clienteNatural.setTelefono(linea.split("--")[4]);
                clienteNatural.setFechaNacimiento(LocalDate.parse(linea.split("--")[5]));
                clienteNatural.setEmail(linea.split("--")[6]);

                clientes.add(clienteNatural);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return clientes;
    }

    public ArrayList<ClienteJuridico> cargarClienteJuridico() throws IOException {
        ArrayList<ClienteJuridico> juridicos = new ArrayList<>();
        ArrayList<String> contenido = archivoUtil.leerArchivo(rutaJuridico);

        String linea; // OJO

        for (String c : contenido) {
            linea = c;
            ClienteJuridico clienteJuridico = new ClienteJuridico();

            clienteJuridico.setNombres(linea.split("--")[0]);
            clienteJuridico.setApellidos(linea.split("--")[1]);
            clienteJuridico.setIdentificacion(linea.split("--")[2]);
            clienteJuridico.setDireccion(linea.split("--")[3]);
            clienteJuridico.setTelefono(linea.split("--")[4]);
            clienteJuridico.setNit(linea.split("--")[5]);

            juridicos.add(clienteJuridico);
        }

        return juridicos;
    }

    /**
     * @return
     * @throws IOException
     */
    public ArrayList<ProductoEnvasado> cargarEnvasados() {

        ArrayList<ProductoEnvasado> envasados = new ArrayList<>();
        ArrayList<String> contenido;
        try {
            contenido = archivoUtil.leerArchivo(rutaEnvasados);
            String linea; // OJO

            for (String c : contenido) {
                linea = c;
                ProductoEnvasado productoEnvasado = new ProductoEnvasado();

                productoEnvasado.setCodigo(linea.split("--")[0]);
                productoEnvasado.setNombreProducto(linea.split("--")[1]);
                productoEnvasado.setDescripcion(linea.split("--")[2]);
                productoEnvasado.setValorUnitario(Double.parseDouble(linea.split("--")[3]));
                productoEnvasado.setExistencias(Integer.parseInt(linea.split("--")[4]));
                productoEnvasado.setFechaEnvasado(LocalDate.parse(linea.split("--")[5]));
                productoEnvasado.setPesoEnvase(linea.split("--")[6]);
                productoEnvasado.setPais(Pais.valueOf(linea.split("--")[7]));

                envasados.add(productoEnvasado);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return envasados;
    }

    public ArrayList<VentaDetalle> cargarVentaDetalles() throws IOException {
        ArrayList<VentaDetalle> detalles = new ArrayList<>();
        ArrayList<String> contenido = archivoUtil.leerArchivo(rutaEnvasados);

        String linea; // OJO

        for (String c : contenido) {
            linea = c;
            VentaDetalle ventaDetalles = new VentaDetalle();

            ventaDetalles.setCodigoVenta(linea.split("--")[0]);
            ventaDetalles.setCantidad(Integer.parseInt(linea.split("--")[1]));
            ventaDetalles.setSubtotal(Double.parseDouble(linea.split("--")[2]));
            //ventaDetalles.setProducto(linea.split("--")[3]));


            detalles.add(ventaDetalles);
        }

        return detalles;
    }

    public ArrayList<ProductoRefrigerado> cargarRefrigerados() throws IOException {
        ArrayList<ProductoRefrigerado> refrigerado = new ArrayList<>();
        ArrayList<String> contenido = archivoUtil.leerArchivo(rutaRefrigerados);

        String linea; // OJO

        for (String c : contenido) {
            linea = c;
            ProductoRefrigerado productoRefrigerado = new ProductoRefrigerado();

            productoRefrigerado.setCodigo(linea.split("--")[0]);
            productoRefrigerado.setNombreProducto(linea.split("--")[1]);
            productoRefrigerado.setValorUnitario(Double.parseDouble(linea.split("--")[2]));
            productoRefrigerado.setDescripcion(linea.split("--")[3]);
            productoRefrigerado.setCodigoAprobacion(linea.split("--")[4]);
            productoRefrigerado.setTemRefrigeracion(linea.split("--")[5]);
            productoRefrigerado.setExistencias(Integer.parseInt(linea.split("--")[6]));


            refrigerado.add(productoRefrigerado);
        }

        return refrigerado;
    }
}
