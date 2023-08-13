package co.edu.uniquindio.programacion3.almacen_uq.modelo;

import java.util.ArrayList;

public class Almacen {

    private ArrayList<ClienteNatural> listaClientesNaturales = new ArrayList<>();

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

    public ArrayList<ClienteNatural> getListaClientesNaturales() {
        return listaClientesNaturales;
    }

}
