package co.edu.uniquindio.programacion3.almacen_uq.modelo;

public abstract class Persona {

    private String nombres;
    private String apellidos;

    public Persona(){

    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
