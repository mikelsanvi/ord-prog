package org.ies.tierno.supermercado;

import lombok.extern.log4j.Log4j;

import java.util.Objects;

@Log4j
public class Presidente extends Empleado {
    private String cadena;

    public Presidente(String nif, String nombre, String apellidos, int horas, String cadena) {
        super(nif, nombre, apellidos, horas);
        this.cadena = cadena;
    }

    @Override
    public void showInfo() {
        log.info("Presidente " + cadena + ". Caja. NIF: " + nif + ". Nombre: " + nombre + ". Apellidos: " + apellidos + ". Horas: " + horas);

    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Presidente that = (Presidente) o;
        return Objects.equals(cadena, that.cadena);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cadena);
    }
}
