package co.edu.uniquindio.programacion3.almacen_uq.modelo;

import java.time.LocalDate;

public class ClienteNatural extends Cliente{

    private String email;
    private LocalDate fechaNacimiento;

    public ClienteNatural(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
