package com.example.mycalculator.mvp.model

import com.example.mycalculator.utils.Utils.EMPTY_TEXT

class CountModel() {
    var firstValue = EMPTY_TEXT
    var sedondValue = EMPTY_TEXT
    var result = EMPTY_TEXT
    var operation = EMPTY_TEXT

    fun cleanValues() {
        firstValue = EMPTY_TEXT
        sedondValue = EMPTY_TEXT
        operation = EMPTY_TEXT
    }

    fun clearResult() {
        result = EMPTY_TEXT
    }
}