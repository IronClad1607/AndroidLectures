package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var firstNum = 0.0
    private var secondNum = 0.0
    private var currOp = '$'
    private var isSetResult = false


    private val calcLogic = CalcLogic()

    private fun attachListener() {

        btnC.setOnClickListener(this)
        btnPlus.setOnClickListener(this)
        btnMinus.setOnClickListener(this)
        btnPro.setOnClickListener(this)
        btnDiv.setOnClickListener(this)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)
        btn0.setOnClickListener(this)
        btnEq.setOnClickListener(this)
    }

    private fun displayNum(currNum: Int) {
        if (currOp != '$') {
            secondNum = secondNum * 10 + currNum
            tvSecond.text = secondNum.toString()
        } else {
            firstNum = firstNum * 10 + currNum
            tvFirst.text = firstNum.toString()
        }
    }

    private fun displayOp(inputOp: Char) {
        if (isSetResult) {
            clear(false)
            tvFirst.text = firstNum.toString()
        }
        currOp = inputOp
        tvOP.text = currOp.toString()
    }

    private fun showresult() {
        val result = calcLogic.evaluate(firstNum, secondNum, currOp)
        Log.d("PUI", "result main $result, ${Double.MIN_VALUE}, $secondNum")

        if (result == Double.MIN_VALUE) {
            tvResult.text = "Division by zero"
        } else
            tvResult.text = result.toString()

        firstNum = result
        isSetResult = true
    }

    private fun clear(allClear: Boolean = true) {
        tvFirst.text = ""
        tvSecond.text = ""
        tvOP.text = ""
        tvResult.text = ""
        secondNum = 0.0
        currOp = '$'
        if (allClear) {
            firstNum = 0.0
        }
        isSetResult = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        attachListener()f

    }

    override fun onClick(p0: View) {
        when (p0.id) {
            R.id.btn0 -> displayNum(0)
            R.id.btn1 -> displayNum(1)
            R.id.btn2 -> displayNum(2)
            R.id.btn3 -> displayNum(3)
            R.id.btn4 -> displayNum(4)
            R.id.btn5 -> displayNum(5)
            R.id.btn6 -> displayNum(6)
            R.id.btn7 -> displayNum(7)
            R.id.btn8 -> displayNum(8)
            R.id.btn9 -> displayNum(9)
            R.id.btnPlus -> displayOp('+')
            R.id.btnMinus -> displayOp('-')
            R.id.btnPro -> displayOp('*')
            R.id.btnDiv -> displayOp('/')
            R.id.btnEq -> showresult()
            R.id.btnC -> clear()


        }
    }
}

