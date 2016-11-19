package com.kebuu.server.dto

import com.kebuu.core.dto.BoardDto
import com.kebuu.core.dto.GamerDto
import com.kebuu.server.game.Game

class GameDto(private val game: Game) {

    fun getCurrentStep() = game.currentStep
    fun getGamers() = game.gamers.map(::GamerDto)
    fun getStatus() = game.status
    fun getBoard() = BoardDto(game.board)
}

