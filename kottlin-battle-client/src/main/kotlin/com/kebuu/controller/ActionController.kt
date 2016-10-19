package com.kebuu.controller

import com.kebuu.Position
import com.kebuu.action.ClientAction
import com.kebuu.action.MoveAction
import com.kebuu.action.NoAction
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalTime

@RestController
@RequestMapping("/action")
internal class ActionController {

    @GetMapping
    fun action(): ClientAction {
        var action: ClientAction = NoAction()

        if(LocalTime.now().second % 2 == 0) {
            action = MoveAction(Position(10, 10))
        }

        return action
    }
}