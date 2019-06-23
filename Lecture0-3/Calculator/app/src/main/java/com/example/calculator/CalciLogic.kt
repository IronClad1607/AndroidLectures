package com.example.calculator

import android.util.Log

class CalcLogic {
    private val OP_ADD = '+'
    private val OP_SUB = '-'
    private val OP_MUL = '*'
    private val OP_DIV = '/'


    fun evaluate(num1: Double, num2: Double, currOp: Char): Double {
        val result = when (currOp) {
            OP_ADD -> num1 + num2
            OP_SUB -> num1 - num2
            OP_MUL -> num1 * num2
            OP_DIV -> try {
                num1 / num2
            } catch (e:Exception) {
                Double.MIN_VALUE
            }
            else -> throw  Exception("Invalid Operator")
        }

        Log.d("PUI","result $result $num2")
        return result
    }
}