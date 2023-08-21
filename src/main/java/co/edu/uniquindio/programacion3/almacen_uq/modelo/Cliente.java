package co.edu.uniquindio.programacion3.almacen_uq.modelo;

import java.time.LocalDate;

public class Cliente extends Persona{

    private String identificacion;
    private String direccion;
    private String telefono;

    // COnstructor vacío
    public Cliente(){

    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
