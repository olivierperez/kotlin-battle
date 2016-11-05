package com.kebuu.core.action

import com.kebuu.core.action.execution.ActionExecutor
import com.kebuu.core.action.validation.ActionValidator

class NoAction: StepAction {

    override fun executeBy(executor: ActionExecutor) = executor.execute(this)

    override fun validateBy(validator: ActionValidator) = validator.validate(this)
}