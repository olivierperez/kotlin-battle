package com.kebuu.server.gamer.bot

import com.kebuu.core.action.NoAction
import com.kebuu.core.action.StepAction
import com.kebuu.core.board.spawn.SpawnAttributes
import com.kebuu.core.bot.Bot
import com.kebuu.core.dto.GameInfo
import com.kebuu.core.gamer.BaseGamer

class ImmobileBot private constructor(gamerId: String, override val type: String): BaseGamer(gamerId), Bot {

    constructor(): this("ImmobileBot-" + Bot.COUNTER.andIncrement, "immobileBot")

    override fun doGetNextAction(gameInfo: GameInfo): StepAction {
        return NoAction()
    }

    override fun doGetSpawnAttributes(point: Int): SpawnAttributes {
        return SpawnAttributes()
    }
}

