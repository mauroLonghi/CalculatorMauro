package com.example.mycalculator.mvp.model

import com.example.mycalculator.utils.Utils.EMPTY_TEXT

class CountModel() {
    var operator_1 = EMPTY_TEXT
    var operator_2 = EMPTY_TEXT
    var result = EMPTY_TEXT
    var operation = EMPTY_TEXT

    fun cleanValues() {
        operator_1 = EMPTY_TEXT
        operator_2 = EMPTY_TEXT
        operation = EMPTY_TEXT
    }

    fun clearResult() {
        result = EMPTY_TEXT
    }
}