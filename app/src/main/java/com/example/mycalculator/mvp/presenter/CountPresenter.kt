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
                model.firstValue += value
                view.clearFieldOperation()
                view.setFieldOperation(model.firstValue)
            }
            else -> {
                model.sedondValue += value
                view.setFieldOperation(model.sedondValue)
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
        var auxResult: Double? = null

        if (model.firstValue == EMPTY_TEXT && model.result != EMPTY_TEXT) {
            model.firstValue = model.result
        }

        if (model.firstValue != EMPTY_TEXT && model.sedondValue != EMPTY_TEXT) {

            when (value) {
                TEXT_BUTTON_PLUS -> {
                    auxResult = model.firstValue.toDouble() + model.sedondValue.toDouble()
                }
                TEXT_BUTTON_MINUS -> {
                    auxResult = model.firstValue.toDouble() - model.sedondValue.toDouble()
                }
                TEXT_BUTTON_MULT -> {
                    auxResult = model.firstValue.toDouble() * model.sedondValue.toDouble()
                }
                TEXT_BUTTON_DIV -> {
                    auxResult = model.firstValue.toDouble() / model.sedondValue.toDouble()
                }

                else -> VALUE_ZERO
            }

        }
        model.result = auxResult.toString()

    }

}