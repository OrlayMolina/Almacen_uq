package co.edu.uniquindio.programacion3.almacen_uq.modelo;

import co.edu.uniquindio.programacion3.almacen_uq.enumm.Pais;

import java.time.LocalDate;

public class ProductoEnvasado extends Producto{

    private LocalDate fechaEnvasado;
    private String pesoEnvase;
    private Pais pais;

    public ProductoEnvasado(){

    }

    public LocalDate getFechaEnvasado() {
        return fechaEnvasado;
    }

    public void setFechaEnvasado(LocalDate fechaEnvasado) {
        this.fechaEnvasado = fechaEnvasado;
    }

    public String getPesoEnvase() {
        return pesoEnvase;
    }

    public void setPesoEnvase(String pesoEnvase) {
        this.pesoEnvase = pesoEnvase;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
