package org.ies.tierno.redsocial.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
public class Video {
    private String titulo;
    private LocalDate fecha;
    private int duracion;
    private Set<String> etiquetas;
}
