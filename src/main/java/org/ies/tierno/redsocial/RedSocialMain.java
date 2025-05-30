package org.ies.tierno.redsocial;

import lombok.extern.log4j.Log4j;
import org.ies.tierno.redsocial.exceptions.CanalNotFoundException;
import org.ies.tierno.redsocial.model.Canal;
import org.ies.tierno.redsocial.model.RedSocial;
import org.ies.tierno.redsocial.model.Seguidor;
import org.ies.tierno.redsocial.model.Video;

import java.time.LocalDate;
import java.util.*;

@Log4j
public class RedSocialMain {


    public static void main(String[] args) {
        var redSocial = createRedSocial();
        Scanner scanner = new Scanner(System.in);

        log.info("Introduce el nombre del canal");
        String nombreCanal = scanner.nextLine();
        try {
            var seguidores = redSocial.findSeguidoresCanal(nombreCanal);
            log.info(seguidores);
        } catch (CanalNotFoundException e) {
            log.info(e.getMessage());
        }

    }

    private static RedSocial createRedSocial() {
        TreeSet<Video> videos = new TreeSet<>(Comparator.comparing(Video::getFecha).thenComparing(Video::getTitulo));
        videos.add(
                new Video("VIdeo 1", LocalDate.now(), 120, Set.of("Drama"))
        );
        videos.add(
                new Video("VIdeo 2", LocalDate.now(), 121, Set.of("Comedia"))
        );
        return new RedSocial(
                "Twitter",
                Map.of(
                        "A", new Canal(
                                "A",
                                "Bob",
                                videos,
                                List.of(
                                        new Seguidor("peppa", "Peppa", "Pig"),
                                        new Seguidor("george", "George", "Pig")
                                )
                        ),
                        "B", new Canal(
                                "B",
                                "Bob",
                                videos,
                                List.of(
                                        new Seguidor("calamar", "Calamardo", "Pig"),
                                        new Seguidor("estrella", "Patricio", "Pig")
                                )
                        )
                )
        );
    }
}
