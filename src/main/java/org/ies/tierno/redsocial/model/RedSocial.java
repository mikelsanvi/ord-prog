package org.ies.tierno.redsocial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.val;
import org.ies.tierno.redsocial.exceptions.CanalNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class RedSocial {
    private String nombre;
    private Map<String, Canal> canalesByNombre;

    public List<Seguidor> findSeguidoresCanal(String nombreCanal) throws CanalNotFoundException {
        if (canalesByNombre.containsKey(nombreCanal)) {
            Canal canal = canalesByNombre.get(nombreCanal);
            return canal.getSeguidores();
        } else {
            throw new CanalNotFoundException(nombreCanal);
        }
    }

    public Video findVideo(String nombreCanal, String titulo) throws CanalNotFoundException {
        if (canalesByNombre.containsKey(nombreCanal)) {
            Canal canal = canalesByNombre.get(nombreCanal);
            for (var video : canal.getVideos()) {
                if (video.getTitulo().equals(titulo)) {
                    return video;
                }
            }
            return null;
        } else {
            throw new CanalNotFoundException(nombreCanal);
        }
    }

    public List<Video> findVideosByTag(String tag) {
        List<Video> tagVideos = new ArrayList<>();
        for (var canal: canalesByNombre.values()) {
            for(var video: canal.getVideos()) {
                if(video.getEtiquetas().contains(tag)) {
                    tagVideos.add(video);
                }
            }
        }
        return tagVideos;
    }

    public List<Seguidor> findAutorSeguidores(String autor) {
        List<Seguidor> seguidores = new ArrayList<>();
        for (var canal: canalesByNombre.values()) {
            if(canal.getAutor().equals(autor)) {
                seguidores.addAll(canal.getSeguidores());
            }
        }
        return seguidores;
    }
}
