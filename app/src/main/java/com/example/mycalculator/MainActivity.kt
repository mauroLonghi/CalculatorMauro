package com.example.mycalculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.mycalculator.mvp.model.CountModel
import com.example.mycalculator.mvp.presenter.CountPresenter
import com.example.mycalculator.mvp.view.CalculatorView
import com.example.mycalculator.utils.Utils.TEXT_BUTTON_DIV
import com.example.mycalculator.utils.Utils.TEXT_BUTTON_EIGHT
import com.example.mycalculator.utils.Utils.TEXT_BUTTON_FIVE
import com.example.mycalculator.utils.Utils.TEXT_BUTTON_FOUR
import com.example.mycalculator.utils.Utils.TEXT_BUTTON_MINUS
import com.example.mycalculator.utils.Utils.TEXT_BUTTON_NINE
import com.example.mycalculator.utils.Utils.TEXT_BUTTON_ONE
import com.example.mycalculator.utils.Utils.TEXT_BUTTON_PLUS
import com.example.mycalculator.utils.Utils.TEXT_BUTTON_MULT
import com.example.mycalculator.utils.Utils.TEXT_BUTTON_SEVEN
import com.example.mycalculator.utils.Utils.TEXT_BUTTON_SIX
import com.example.mycalculator.utils.Utils.TEXT_BUTTON_THREE
import com.example.mycalculator.utils.Utils.TEXT_BUTTON_TWO
import com.example.mycalculator.utils.Utils.TEXT_BUTTON_ZERO
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var presenter: CountPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = CountPresenter(CountModel(), CalculatorView(this))

        button_0.setOnClickListener {
            presenter?.valueNumber(TEXT_BUTTON_ZERO)
        }
        button_1.setOnClickListener {
            presenter?.valueNumber(TEXT_BUTTON_ONE)
        }
        button_2.setOnClickListener {
            presenter?.valueNumber(TEXT_BUTTON_TWO)
        }
        button_3.setOnClickListener {
            presenter?.valueNumber(TEXT_BUTTON_THREE)
        }
        button_4.setOnClickListener {
            presenter?.valueNumber(TEXT_BUTTON_FOUR)
        }
        button_5.setOnClickListener {
            presenter?.valueNumber(TEXT_BUTTON_FIVE)
        }
        button_6.setOnClickListener {
            presenter?.valueNumber(TEXT_BUTTON_SIX)
        }
        button_7.setOnClickListener {
            presenter?.valueNumber(TEXT_BUTTON_SEVEN)
        }
        button_8.setOnClickListener {
            presenter?.valueNumber(TEXT_BUTTON_EIGHT)
        }
        button_9.setOnClickListener {
            presenter?.valueNumber(TEXT_BUTTON_NINE)
        }
        button_divide.setOnClickListener {
            presenter?.valueOperator(TEXT_BUTTON_DIV)
        }
        button_product.setOnClickListener {
            presenter?.valueOperator(TEXT_BUTTON_MULT)
        }
        button_sum.setOnClickListener {
            presenter?.valueOperator(TEXT_BUTTON_PLUS)
        }
        button_difference.setOnClickListener {
            presenter?.valueOperator(TEXT_BUTTON_MINUS)
        }
        button_del.setOnClickListener {
            presenter?.deleteLast()
        }
        button_clear.setOnClickListener {
            presenter?.clearSet()
        }
        button_result.setOnClickListener {
            presenter?.valueResult()
        }

    }

}