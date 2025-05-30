package org.ies.tierno.supermercado;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class Cajero extends Empleado {
    private String tienda;
    private int caja;

    public Cajero(String nif, String nombre, String apellidos, int horas, String tienda, int caja) {
        super(nif, nombre, apellidos, horas);
        this.tienda = tienda;
        this.caja = caja;
    }

    @Override
    public void showInfo() {
        log.info("Cajero " + tienda + ". Caja " + caja + ". NIF: " + nif + ". Nombre: " + nombre + ". Apellidos: " + apellidos + ". Horas: " + horas);
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

    public int getCaja() {
        return caja;
    }

    public void setCaja(int caja) {
        this.caja = caja;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cajero cajero = (Cajero) o;
        return caja == cajero.caja && Objects.equals(tienda, cajero.tienda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tienda, caja);
    }
}
