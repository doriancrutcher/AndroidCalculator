package com.example.androidcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var button1:Button?=null
    var button2: Button? = null
    var button3: Button? = null
    var button4: Button? = null
    var button5: Button? = null
    var button6: Button? = null
    var button7: Button? = null
    var button8: Button? = null
    var button9: Button? = null
    var button0: Button? = null
    var buttonEquals: Button? = null
    var buttonMinus: Button? = null
    var buttonPlus: Button? = null
    var buttonMultiply: Button? = null
    var buttonDivide:Button?=null
    var buttonClear:Button?=null
    var numView: TextView? = null
    var firstNumber:Double?=0.0
    var secondNumber:Double?=0.0
    var operationAction:String?=null
    var equalsHit:Boolean=false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button0 = findViewById(R.id.button0)
        button0?.setOnClickListener { clickTest(0) }

        button1 = findViewById(R.id.button1)
        button1?.setOnClickListener { clickTest(1) }

        button2 = findViewById(R.id.button2)
        button2?.setOnClickListener { clickTest(2) }

        button3 = findViewById(R.id.button3)
        button3?.setOnClickListener { clickTest(3) }

        button4 = findViewById(R.id.button4)
        button4?.setOnClickListener { clickTest(4) }

        button5 = findViewById(R.id.button5)
        button5?.setOnClickListener { clickTest(5) }

        button6 = findViewById(R.id.button6)
        button6?.setOnClickListener { clickTest(6) }

        button7 = findViewById(R.id.button7)
        button7?.setOnClickListener { clickTest(7) }

        button8 = findViewById(R.id.button8)
        button8?.setOnClickListener { clickTest(8) }

        button9 = findViewById(R.id.button9)
        button9?.setOnClickListener { clickTest(9) }

        buttonPlus = findViewById(R.id.buttonPlus)
        buttonPlus?.setOnClickListener { operation("plus") }

        buttonDivide = findViewById(R.id.buttonDivison)
        buttonDivide?.setOnClickListener { operation("divide") }

        buttonMinus = findViewById(R.id.buttonMinus)
        buttonMinus?.setOnClickListener { operation("minus") }

        buttonMultiply = findViewById(R.id.buttonTimes)
        buttonMultiply?.setOnClickListener { operation("multiply") }

        buttonEquals = findViewById(R.id.buttonEquals)
        buttonEquals?.setOnClickListener { equalsAction() }

        buttonClear=findViewById(R.id.buttonCLR)
        buttonClear?.setOnClickListener { clearAction() }


        numView=findViewById(R.id.NumberView)



    }


    fun clickTest(num:Int){
        if (equalsHit) {numView?.setText(""); equalsHit=false} else equalsHit = false


        if(numView?.text=="0")
        numView?.setText(num.toString())
        else{
            numView?.append(num.toString())
        }
    }

    fun  operation(operation:String){
        var currentString:String=numView?.text.toString()
        currentString = if (currentString.contains(".")) currentString else currentString + ".0"
        firstNumber=currentString.toDouble()
        when (operation) {
            "plus" -> operationAction = "+"
            "minus" -> operationAction = "-"
            "multiply" -> operationAction = "*"
            "divide" -> operationAction = "/"
        }
        numView?.setText("")

    }

    fun equalsAction(){
        equalsHit=true
        var result: Double? = null
        var currentString: String = numView?.text.toString()
        currentString = if (currentString.contains(".")) currentString else currentString + ".0"

        val tempSecondNumber = currentString.toDoubleOrNull()

        if (tempSecondNumber == null) {
            numView?.text = "Invalid input"
            return
        }

        secondNumber = tempSecondNumber

        when (operationAction) {
            "+" -> result = firstNumber!! + secondNumber!!
            "-" -> result = firstNumber!! - secondNumber!!
            "*" -> result = firstNumber!! * secondNumber!!
            "/" -> {
                if (secondNumber != 0.0) {
                    result = firstNumber!! / secondNumber!!
                } else {
                    numView?.text = "Cannot divide by zero"
                    return
                }
            }
        }

        numView?.text = result.toString()
    }

    fun clearAction(){
        secondNumber=0.0;
        firstNumber=0.0;
        numView?.setText("0")
    }

}