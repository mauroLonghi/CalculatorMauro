package com.example.mycalculator.mvp.view

import android.app.Activity
import android.text.TextUtils.substring
import android.util.Log
import com.example.mycalculator.utils.Utils.EMPTY_TEXT
import kotlinx.android.synthetic.main.activity_main.*

class CalculatorView(activity: Activity) : ActivityView(activity) {

    fun setFieldResult(result: String) {
        activity?.result_text?.text = result
    }

    fun setFieldOperation(operation: String) {
        val fieldOperation = activity?.result_operation?.text
        activity?.result_operation?.text = "$operation"
    }

    fun clearFieldOperation() {
        activity?.result_operation?.text = EMPTY_TEXT
    }

    fun clearLastItem(){
        val field=activity?.result_operation?.text.toString().substring(0, activity?.result_operation?.text.toString().length - 1)
        activity?.result_operation?.text = field
    }
}
