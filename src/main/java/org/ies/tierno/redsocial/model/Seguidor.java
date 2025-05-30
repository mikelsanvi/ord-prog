package org.ies.tierno.redsocial.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Seguidor {
    private String username;
    private String nombre;
    private String apellidos;
}
