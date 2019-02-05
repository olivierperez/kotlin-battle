package com.kebuu.client.service.impl

import com.kebuu.core.Dimension
import com.kebuu.core.dto.GameInfo
import com.kebuu.core.dto.board.item.AbstractBoardItemDto

object Database {

    lateinit var dimension: Dimension

    lateinit var items: List<AbstractBoardItemDto>

    lateinit var gameInfo: GameInfo

    fun update(info: GameInfo) {
        dimension = info.board.dimension ?: dimension
        items = info.board.boardItems
        gameInfo = info
    }
}