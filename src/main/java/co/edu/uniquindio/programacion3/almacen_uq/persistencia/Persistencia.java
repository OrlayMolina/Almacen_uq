package co.edu.uniquindio.programacion3.almacen_uq.persistencia;

import co.edu.uniquindio.programacion3.almacen_uq.enumm.Pais;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.Cliente;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.ClienteJuridico;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.ClienteNatural;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.ProductoEnvasado;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Persistencia {

    public ArchivoUtil archivoUtil = new ArchivoUtil();

    // OJO, tener el cuenta cambiar la ruta donde se almacenan los archivos.


    public static final String rutaArchivos = "C:\\Users\\Orlay.molina\\programacion3\\almacen\\src\\main\\java\\co\\edu\\uniquindio\\programacion3\\almacen_uq\\archivos\\Cliente.txt";

    public static final String rutaLog = "C:\\Users\\Orlay.molina\\programacion3\\almacen\\src\\main\\java\\co\\edu\\uniquindio\\programacion3\\almacen_uq\\archivos\\ClienteLog.txt";

    public static final String rutaArchivosClienteJuridico ="C:\\Users\\Orlay.molina\\programacion3\\almacen\\src\\main\\java\\co\\edu\\uniquindio\\programacion3\\almacen_uq\\archivos\\ClienteJuridico.txt";

    public static final String rutaLogClienteJuridico = "C:\\Users\\Orlay.molina\\programacion3\\almacen\\src\\main\\java\\co\\edu\\uniquindio\\programacion3\\almacen_uq\\archivos\\ClienteJuridicoLog.txt";

    public static final String rutaEnvasados = "C:\\Users\\Orlay.molina\\programacion3\\almacen\\src\\main\\java\\co\\edu\\uniquindio\\programacion3\\almacen_uq\\archivos\\Envasados.txt";

    public static final String rutaLogEnvasados = "C:\\Users\\Orlay.molina\\programacion3\\almacen\\src\\main\\java\\co\\edu\\uniquindio\\programacion3\\almacen_uq\\archivos\\EnvasadosLog.txt";

    public void guardarArchivoLog(String mensajeLog, int nivel, String accion){
        archivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, rutaLog);
    }

    public void guardarArchivoLogJuridico(String mensajeLog, int nivel, String accion){
        archivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, rutaLogClienteJuridico);
    }

    public void guardarArchivoLogEnvasados(String mensajeLog, int nivel, String accion){
        archivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, rutaLogEnvasados);
    }

    public void guardarCliente(ArrayList<ClienteNatural> listaClientesNaturales) throws IOException {
        StringBuilder contenido = new StringBuilder();
        for(ClienteNatural n : listaClientesNaturales){
            contenido.append(n.getNombres()).append("--").
                    append(n.getApellidos()).append("--").
                    append(n.getIdentificacion()).append("--").
                    append(n.getDireccion()).append("--").
                    append(n.getTelefono()).append("--").
                    append(n.getFechaNacimiento()).append("--").
                    append(n.getEmail()).append("\n");

            archivoUtil.guardarArchivo(rutaArchivos, contenido.toString(),true);
        }
    }

    public void guardarClienteJuridico(ArrayList<ClienteJuridico> listaClientesJuridico) throws IOException {
        StringBuilder contenido = new StringBuilder();
        for(ClienteJuridico n : listaClientesJuridico){
            contenido.append(n.getNombres()).append("--").
                    append(n.getApellidos()).append("--").
                    append(n.getIdentificacion()).append("--").
                    append(n.getDireccion()).append("--").
                    append(n.getTelefono()).append("--").
                    append(n.getNit()).append("\n");

            archivoUtil.guardarArchivo(rutaArchivosClienteJuridico, contenido.toString(),true);
        }
    }

    public void guardarProductosEnvasados(ArrayList<ProductoEnvasado> listaProductosEnvasados) throws IOException {
        StringBuilder contenido = new StringBuilder();
        for(ProductoEnvasado e : listaProductosEnvasados){
            contenido.append(e.getCodigo()).append("--").
                    append(e.getNombreProducto()).append("--").
                    append(e.getDescripcion()).append("--").
                    append(e.getValorUnitario()).append("--").
                    append(e.getExistencias()).append("--").
                    append(e.getFechaEnvasado()).append("--").
                    append(e.getPesoEnvase()).append("--").
                    append(e.getPais()).append("\n");

            archivoUtil.guardarArchivo(rutaEnvasados, contenido.toString(),true);
        }
    }

    public ArrayList<ClienteNatural> cargarCliente() throws IOException{
        ArrayList<ClienteNatural> clientes = new ArrayList<>();
        ArrayList<String> contenido = archivoUtil.leerArchivo(rutaArchivos);

        String linea; // OJO

        for(String c : contenido){
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

        return clientes;
    }

    public ArrayList<ClienteJuridico> cargarClienteJuridico() throws IOException{
        ArrayList<ClienteJuridico> clientes = new ArrayList<>();
        ArrayList<String> contenido = archivoUtil.leerArchivo(rutaArchivosClienteJuridico);

        String linea; // OJO

        for(String c : contenido){
            linea = c;
            ClienteJuridico clienteJuridico = new ClienteJuridico();

            clienteJuridico.setNombres(linea.split("--")[0]);
            clienteJuridico.setApellidos(linea.split("--")[1]);
            clienteJuridico.setIdentificacion(linea.split("--")[2]);
            clienteJuridico.setDireccion(linea.split("--")[3]);
            clienteJuridico.setTelefono(linea.split("--")[4]);
            clienteJuridico.setNit(linea.split("--")[5]);

            clientes.add(clienteJuridico);
        }

        return clientes;
    }

    public ArrayList<ProductoEnvasado> cargarEnvasados() throws IOException{
        ArrayList<ProductoEnvasado> envasados = new ArrayList<>();
        ArrayList<String> contenido = archivoUtil.leerArchivo(rutaArchivos);

        String linea; // OJO

        for(String c : contenido){
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

        return envasados;
    }
}
