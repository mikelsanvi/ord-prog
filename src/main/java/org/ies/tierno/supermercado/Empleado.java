package org.ies.tierno.supermercado;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class Empleado {
    protected String nif;
    protected String nombre;
    protected String apellidos;
    protected int horas;


    public void addHoras(int horas) {
        this.horas += horas;
    }

    public abstract void showInfo();
}
