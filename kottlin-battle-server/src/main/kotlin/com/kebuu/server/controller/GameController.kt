package com.kebuu.server.controller

import com.kebuu.core.game.Game
import com.kebuu.server.dto.GameDto
import com.kebuu.server.game.GameManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/games")
internal class GameController @Autowired constructor(val gameManager: GameManager) {

    @GetMapping
    fun getGames(): Collection<Game> {
        return gameManager.games
    }

    @GetMapping("/active")
    fun getActiveGame(): GameDto {
        return GameDto(gameManager.getActiveGame())
    }

    @GetMapping("/start")
    fun getAciveGame() {
        Thread(Runnable {
            gameManager.start()
        }).start()
    }

    @PostMapping
    fun createGame(): GameDto {
        return GameDto(gameManager.createGame())
    }
}
