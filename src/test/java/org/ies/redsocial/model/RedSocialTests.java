package org.ies.redsocial.model;

import org.ies.tierno.redsocial.exceptions.CanalNotFoundException;
import org.ies.tierno.redsocial.model.Canal;
import org.ies.tierno.redsocial.model.RedSocial;
import org.ies.tierno.redsocial.model.Seguidor;
import org.ies.tierno.redsocial.model.Video;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

public class RedSocialTests {
    @Test
    public void getSeguidoresTest() throws CanalNotFoundException {

        var redSocial = createRedSocial();

        var res = redSocial.findSeguidoresCanal("A");

        Assertions.assertEquals(
                List.of(
                        new Seguidor("peppa", "Peppa", "Pig"),
                        new Seguidor("george", "George", "Pig")
                ),
                res
        );
    }

    @Test
    public void getSeguidoresNotFoundTest()  {

        Assertions.assertThrows(
                CanalNotFoundException.class,
                () ->{
                    var redSocial = createRedSocial();

                    var res = redSocial.findSeguidoresCanal("sdfsdsdf");
                }

        );
    }

    private RedSocial createRedSocial() {
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
