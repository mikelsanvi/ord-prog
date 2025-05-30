package org.ies.tierno.redsocial.exceptions;

public class CanalNotFoundException extends Exception{
    private final String nombreCanal;

    public CanalNotFoundException(String nombreCanal) {
        super("No se ha encontrado el canal " + nombreCanal);
        this.nombreCanal = nombreCanal;
    }

    public String getNombreCanal() {
        return nombreCanal;
    }
}
