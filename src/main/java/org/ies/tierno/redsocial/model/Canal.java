package org.ies.tierno.redsocial.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.TreeSet;

@Data
@AllArgsConstructor
public class Canal {
    private String nombre;
    private String autor;
    private TreeSet<Video> videos;
    private List<Seguidor> seguidores;

}
