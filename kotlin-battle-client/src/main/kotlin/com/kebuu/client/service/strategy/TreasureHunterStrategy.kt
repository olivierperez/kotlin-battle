package com.kebuu.client.service.strategy

import com.kebuu.client.service.impl.Database
import com.kebuu.core.Position
import com.kebuu.core.action.DigAction
import com.kebuu.core.action.MoveAction
import com.kebuu.core.action.NoAction
import com.kebuu.core.action.StepAction
import com.kebuu.core.dto.board.item.AbstractBoardItemDto
import com.kebuu.core.dto.board.item.TreasureBoardItemDto

class TreasureHunterStrategy : Strategy {

    override fun action(): StepAction {

        val position = Database.gameInfo.position

        val closest = Database.items
            .filter { item -> item is TreasureBoardItemDto }
            .minBy { item ->
                position distanceWith item.position
            }

        return if (closest != null && closest.position.x == position.x && closest.position.y == position.y) {
            DigAction()
        } else {
            val best = bestRatioPointsDistance(Database.items, position)
            position.goTo(best)
        }
    }

    private fun bestRatioPointsDistance(items: List<AbstractBoardItemDto>, position: Position): AbstractBoardItemDto? {
        return items
            .filter { item -> item is TreasureBoardItemDto }
            .maxBy { item ->
                val distance = position distanceWith item.position
                (item as TreasureBoardItemDto).zPoints.toFloat() / distance
            }
    }

}

private fun Position.goTo(best: AbstractBoardItemDto?): StepAction {
    return when {
        best == null -> NoAction()
        best.position.x < x -> MoveAction(left)
        best.position.y < y -> MoveAction(up)
        best.position.x > x -> MoveAction(right)
        best.position.y > y -> MoveAction(down)
        else -> NoAction()
    }
}

private val Position.left: Position
    get() = Position(x - 1, y)

private val Position.up: Position
    get() = Position(x, y - 1)

private val Position.right: Position
    get() = Position(x + 1, y)

private val Position.down: Position
    get() = Position(x, y + 1)

private infix fun Position.distanceWith(other: Position): Int =
    Math.abs(other.x - x) + Math.abs(other.y - y)
