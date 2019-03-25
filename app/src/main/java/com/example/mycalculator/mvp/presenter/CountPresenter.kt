package com.example.mycalculator.mvp.presenter

import com.example.mycalculator.mvp.model.CountModel
import com.example.mycalculator.mvp.view.CalculatorView
import com.example.mycalculator.utils.Utils.EMPTY_TEXT
import com.example.mycalculator.utils.Utils.TEXT_BUTTON_DIV
import com.example.mycalculator.utils.Utils.TEXT_BUTTON_MINUS
import com.example.mycalculator.utils.Utils.TEXT_BUTTON_PLUS
import com.example.mycalculator.utils.Utils.TEXT_BUTTON_MULT
import com.example.mycalculator.utils.Utils.VALUE_ZERO

class CountPresenter(val model: CountModel, val view: CalculatorView) {

    fun valueNumber(value: String) {

        when {
            model.operation == EMPTY_TEXT -> {
                model.operator_1 += value
                view.clearFieldOperation()
                view.setFieldOperation(model.operator_1)
            }
            else -> {
                model.operator_2 += value
                view.setFieldOperation(model.operator_2)
            }
        }
    }

    fun clearSet() {
        model.cleanValues()
        model.clearResult()
        view.setFieldResult(EMPTY_TEXT)
        view.clearFieldOperation()
    }

    fun valueResult() {
        enterOperation(model.operation)
        view.setFieldResult(model.result)
        view.clearFieldOperation()
        model.cleanValues()
    }

    fun valueOperator(operator: String) {
        model.operation = operator
        view.setFieldOperation(model.operation)
    }

    fun deleteLast() {
        view.clearLastItem()
    }

    fun enterOperation(value: String) {
        var auxResult: Double? = VALUE_ZERO

        if (value!= EMPTY_TEXT) {
            if (model.operator_1 == EMPTY_TEXT && model.result != EMPTY_TEXT) {
                model.operator_1 = model.result
            }

            if (model.operator_1 != EMPTY_TEXT && model.operator_2 != EMPTY_TEXT) {

                when (value) {
                    TEXT_BUTTON_PLUS -> {
                        auxResult = model.operator_1.toDouble() + model.operator_2.toDouble()
                    }
                    TEXT_BUTTON_MINUS -> {
                        auxResult = model.operator_1.toDouble() - model.operator_2.toDouble()
                    }
                    TEXT_BUTTON_MULT -> {
                        auxResult = model.operator_1.toDouble() * model.operator_2.toDouble()
                    }
                    TEXT_BUTTON_DIV -> {
                        auxResult = model.operator_1.toDouble() / model.operator_2.toDouble()
                    }

                    else -> auxResult=VALUE_ZERO
                }

            }
        }else {
            auxResult=model.operator_1.toDouble()
        }
        model.result = auxResult.toString()

    }

}