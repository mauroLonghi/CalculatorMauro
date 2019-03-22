package com.example.mycalculator.mvp.presenter

import com.example.mycalculator.mvp.model.CountModel
import com.example.mycalculator.mvp.view.CalculatorView
import com.example.mycalculator.utils.Utils.EMPTY_TEXT

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

    fun getResult() {
        enterOperation(model.operation)
        view.setFieldResult(model.result)
        view.clearFieldOperation()
        model.cleanValues()
    }

    fun getOperador(operator: String) {
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
                "+" -> {
                    auxResult = model.firstValue.toDouble() + model.sedondValue.toDouble()
                }
                "-" -> {
                    auxResult = model.firstValue.toDouble() - model.sedondValue.toDouble()
                }
                "*" -> {
                    auxResult = model.firstValue.toDouble() * model.sedondValue.toDouble()
                }
                "/" -> {
                    auxResult = model.firstValue.toDouble() / model.sedondValue.toDouble()
                }

                else -> 0.0
            }

        }
        model.result = auxResult.toString()

    }

}