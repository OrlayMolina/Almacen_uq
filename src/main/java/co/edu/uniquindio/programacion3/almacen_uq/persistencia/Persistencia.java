package co.edu.uniquindio.programacion3.almacen_uq.persistencia;

import co.edu.uniquindio.programacion3.almacen_uq.modelo.Cliente;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.ClienteJuridico;
import co.edu.uniquindio.programacion3.almacen_uq.modelo.ClienteNatural;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Persistencia {

    public ArchivoUtil archivoUtil = new ArchivoUtil();

    // OJO, tener el cuenta cambiar la ruta donde se almacenan los archivos.

    public static final String rutaArchivos = "G:\\Mi unidad\\Universidad\\Quinto Semestre\\Programacion 3\\Almacen_uq\\src\\main\\java\\co\\edu\\uniquindio\\programacion3\\almacen_uq\\archivos\\archivosCliente.txt";

    public static final String rutaLog = "G:\\Mi unidad\\Universidad\\Quinto Semestre\\Programacion 3\\Almacen_uq\\src\\main\\java\\co\\edu\\uniquindio\\programacion3\\almacen_uq\\archivos\\ClienteLog.txt";

    public static final String rutaArchivosClienteJuridico ="C:\\Users\\Orlay.molina\\programacion3\\almacen\\src\\main\\java\\co\\edu\\uniquindio\\programacion3\\almacen_uq\\archivos\\ClienteJuridico.txt";

    public static final String rutaLogClienteJuridico = "C:\\Users\\Orlay.molina\\programacion3\\almacen\\src\\main\\java\\co\\edu\\uniquindio\\programacion3\\almacen_uq\\archivos\\ClienteJuridicoLog.txt";


    public void guardarArchivoLog(String mensajeLog, int nivel, String accion){
        archivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, rutaLog);
    }

    public void guardarArchivoLogJuridico(String mensajeLog, int nivel, String accion){
        archivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, rutaLogClienteJuridico);
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

    public void guardarClienteJuridico(ArrayList<ClienteJuridico> listaClientesNaturales) throws IOException {
        StringBuilder contenido = new StringBuilder();
        for(ClienteJuridico n : listaClientesNaturales){
            contenido.append(n.getNombres()).append("--").
                    append(n.getApellidos()).append("--").
                    append(n.getIdentificacion()).append("--").
                    append(n.getDireccion()).append("--").
                    append(n.getTelefono()).append("--").
                    append(n.getNit()).append("\n");

            archivoUtil.guardarArchivo(rutaArchivosClienteJuridico, contenido.toString(),true);
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
}
