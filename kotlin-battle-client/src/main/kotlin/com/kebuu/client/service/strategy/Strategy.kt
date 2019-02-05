package com.kebuu.client.service.strategy

import com.kebuu.core.action.StepAction

interface Strategy {
    fun action(): StepAction
}