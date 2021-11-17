package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    var a : Double = 0.0
    var b : Double = 0.0
    var aa : Long = 0
    var state : Int = 1
    var znak : Char = '0'
    var dot1 : Double = 10.0
    var dot2 : Double = 10.0
    fun buttonClick(view: android.view.View) {
        val labelka = findViewById<TextView>(R.id.labelka)
        labelka.text = state.toString()
    }

    fun liczba(wartosc :Int) {
        val labelka = findViewById<TextView>(R.id.labelka)
        when (state) {
           1->{
                a *= 10
                a += wartosc
                aa = a.toLong()
                labelka.text = aa.toString()
            }
            2-> {
                b *= 10
                b += wartosc
                aa = b.toLong()
                labelka.text = aa.toString()
            }
            3->{
                a+= wartosc.toDouble()/dot1
                dot1*=10
                labelka.text = a.toString()
            }
            4->{
                b+= wartosc.toDouble()/dot2
                dot2*=10
                labelka.text = b.toString()
            }
            0,-1,5->{
                b = wartosc.toDouble()
                aa = b.toLong()
                labelka.text = aa.toString()
                state = 2
            }

        }

    }
    fun znak()
    {
        val labelka = findViewById<TextView>(R.id.labelka)
        when (state){
            1->{
                a = -a
                aa = a.toLong()
                labelka.text = aa.toString()
            }
            2->{
                b = -b
                aa = b.toLong()
                labelka.text = aa.toString()
            }
            3->{
                a = -a
                labelka.text = a.toString()
            }
            4->{
                b = -b
                labelka.text = b.toString()
            }
            -1,0,5->{
                b= - 0.0
                aa = b.toLong()
                labelka.text = aa.toString()
                state = 2
            }
        }
    }
    fun dot(){
        val labelka = findViewById<TextView>(R.id.labelka)
      when (state){
          5,-1,0,1->{
              state = 3
              labelka.text = a.toString();
          }
          2->{
              state = 4
              labelka.text = b.toString()
          }
      }
    }
    fun rowna() {
        dot1 = 10.0
        dot2 = 10.0
        val labelka = findViewById<TextView>(R.id.labelka)
        when (state) {
            -1,0,2,4,5->{
                when(znak) {
                    '+'->{
                        a+=b
                        if(a % 1.0 == 0.0){
                            aa = a.toLong()
                            labelka.text = aa.toString()
                            state = 0
                        }
                        else{
                            labelka.text = a.toString()
                            state = -1
                        }
                    }
                    '-'->{
                        a-=b
                        if(a % 1.0 == 0.0){
                            aa = a.toLong()
                            labelka.text = aa.toString()
                            state = 0
                        }
                        else{
                            labelka.text = a.toString()
                            state = -1
                        }
                    }
                    '*'->{
                        a*=b
                        if(a % 1.0 == 0.0){
                            aa = a.toLong()
                            labelka.text = aa.toString()
                            state = 0
                        }
                        else{
                            labelka.text = a.toString()
                            state = -1
                        }
                    }
                    '/'->{
                        if(b!=0.0){
                            a/=b
                            if(a % 1.0 == 0.0){
                                aa = a.toLong()
                                labelka.text = aa.toString()
                                state = 0
                            }
                            else{
                                labelka.text = a.toString()
                                state = -1
                            }
                        }
                        else {
                            labelka.text = "Error, press C"
                            state = -2
                        }
                    }
                }
            }
        }
    }
    fun dodaj()
    {
        val labelka = findViewById<TextView>(R.id.labelka)
        when (state) {
           1,3,0,-1-> {
               state = 2
               b= 0.0
               labelka.text = ""
               znak = '+'
           }
            5,4,2->{
                rowna()
                znak = '+'
                state = 5
            }
        }
    }
    fun odejmij()
    {
        val labelka = findViewById<TextView>(R.id.labelka)
        when (state) {
            1,3,0,-1-> {
                state = 2
                b= 0.0
                labelka.text = ""
                znak = '-'
            }
            5,4,2->{
                rowna()
                znak = '-'
                state = 5
            }
        }
    }
    fun podziel()
    {
        val labelka = findViewById<TextView>(R.id.labelka)
        when (state) {
            1,3,0,-1-> {
                state = 2
                b= 0.0
                labelka.text = ""
                znak = '/'
            }
            5,4,2->{
                rowna()
                znak = '/'
                state = 5
            }
        }
    }
    fun mnozenie()
    {
        val labelka = findViewById<TextView>(R.id.labelka)
        when (state) {
            1,3,0,-1-> {
                state = 2
                b= 0.0
                labelka.text = ""
                znak = '*'
            }
            5,4,2->{
                rowna()
                znak = '*'
                state = 5
            }
        }
    }
    fun clear()
    {
        val labelka = findViewById<TextView>(R.id.labelka)
        a = 0.0
        b = 0.0
        aa = 0
        state = 1
        znak= '0'
        labelka.text=""
        dot1=10.0
        dot2=10.0
    }
    fun buttonOne(view: android.view.View) {liczba(1)}
    fun buttonTwo(view: android.view.View) {liczba(2)}
    fun buttonThree(view: android.view.View) {liczba(3)}
    fun buttonFour(view: android.view.View) {liczba(4)}
    fun buttonFive(view: android.view.View) {liczba(5)}
    fun buttonSix(view: android.view.View) {liczba(6)}
    fun buttonSeven(view: android.view.View) {liczba(7)}
    fun buttonEight(view: android.view.View) {liczba(8)}
    fun buttonNine(view: android.view.View) {liczba(9)}
    fun buttonZero(view: android.view.View) {liczba(0)}
    fun buttonPlus(view: android.view.View) {dodaj()}
    fun buttonMinus(view: android.view.View) {odejmij()}
    fun buttonMultiply(view: android.view.View) {mnozenie()}
    fun buttonDivide(view: android.view.View) {podziel()}
    fun buttonEqual(view: android.view.View) {rowna()}
    fun buttonClear(view: android.view.View) {clear()}
    fun buttonDot(view: android.view.View) {dot()}
    fun buttonSign(view: android.view.View) {znak()}
}