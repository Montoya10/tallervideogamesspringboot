package com.example.videogames.controller;

import com.example.videogames.model.VideoGame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class VideogameController {

    private static final Logger logger = LoggerFactory.getLogger(VideogameController.class);

    @GetMapping("/videogames")
    public String listar(Model model) {
        List<VideoGame> games = getGames();
        model.addAttribute("games", games);
        return "lista";
    }

    @GetMapping("/videogames/buy/{id}")
    public String buy(@PathVariable("id") int id, Model model) {
        List<VideoGame> games = getGames();
        if (id < 0 || id >= games.size()) {
            logger.warn("ID de videojuego fuera de rango: {}", id);
            return "redirect:/videogames";
        }
        VideoGame game = games.get(id);
        model.addAttribute("game", game);
        model.addAttribute("id", id);
        return "compra";
    }

    @PostMapping("/videogames/buy/{id}/confirm")
    public String confirmPurchase(@PathVariable("id") int id, Model model) {
        List<VideoGame> games = getGames();
        if (id < 0 || id >= games.size()) {
            logger.warn("ID de videojuego fuera de rango en confirm: {}", id);
            return "redirect:/videogames";
        }
        VideoGame game = games.get(id);

        // Simulate order details
        String orderId = java.util.UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        java.time.format.DateTimeFormatter fmt = java.time.format.DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss");
        String timestamp = java.time.LocalDateTime.now().format(fmt);

        model.addAttribute("game", game);
        model.addAttribute("orderId", orderId);
        model.addAttribute("timestamp", timestamp);

        logger.info("Compra simulada: orderId={} game={}", orderId, game.getTitle());

        return "gracias";
    }

    private List<VideoGame> getGames() {
        return List.of(
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
    }
}
