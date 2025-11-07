package com.example.videogames.controller;

import com.example.videogames.model.VideoGame;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class VideogameController {

    @GetMapping("/videogames")
    public String listar(Model model) {

        // Ahora listamos 12 videojuegos (triplicado desde 4)
        List<VideoGame> games = List.of(
            new VideoGame("Minecraft", "Juego de construcción y supervivencia.", 79.900, "minecraft.jpg"),
            new VideoGame("GTA V", "Acción y mundo abierto en Los Santos.", 119.900, "gtav.jpg"),
            new VideoGame("FIFA 23", "Simulador de fútbol con equipos reales.", 149.900, "fifa23.jpg"),
            new VideoGame("Call of Duty", "Juego de disparos con multijugador online.", 99.900, "callofduty.jpg"),
            new VideoGame("The Legend of Zelda", "Aventura épica en un mundo abierto.", 129.900, "zelda.jpg"),
            new VideoGame("Super Mario Odyssey", "Plataformas y exploración con Mario.", 89.900, "mario.jpg"),
            new VideoGame("Cyberpunk 2077", "RPG futurista y narrativa inmersiva.", 139.900, "cyberpunk.jpg"),
            new VideoGame("Red Dead Redemption 2", "Aventura del Lejano Oeste.", 159.900, "rdr2.jpg"),
            new VideoGame("Among Us", "Juego social de deducción y engaño.", 19.900, "amongus.jpg"),
            new VideoGame("Minecraft Dungeons", "Aventura de mazmorras en el universo de Minecraft.", 49.900, "minecraft_dungeons.jpg"),
            new VideoGame("Resident Evil Village", "Survival horror con acción intensa.", 129.900, "re8.jpg"),
            new VideoGame("Assassin's Creed Valhalla", "Aventura vikinga en mundo abierto.", 139.900, "ac_valhalla.jpg")
        );

        model.addAttribute("games", games);

        return "lista";
    }
}
