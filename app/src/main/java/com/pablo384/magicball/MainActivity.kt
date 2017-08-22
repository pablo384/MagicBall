package com.pablo384.magicball

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val COLOR= "color"
    val TEXTO="texto"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //1- clic listener
        //2- generar un color aleatorio
        //3- generar una frase aleatoria

        pressMeButton.setOnClickListener {
            val colors = intArrayOf(Color.CYAN, Color.RED, Color.MAGENTA, Color.GREEN, Color.BLACK)
            val phrases = resources.getStringArray(R.array.phrases)
            val randomColor= colors.getRandomElement()

            pressMeButton.setBackgroundColor(randomColor)
            phraseTextView.text= phrases.getRandomElement()
            phraseTextView.setTextColor(randomColor)
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(COLOR, phraseTextView.currentTextColor)
        outState.putString(TEXTO, phraseTextView.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        with(savedInstanceState){
            phraseTextView.text=getString(TEXTO)
            phraseTextView.setTextColor(getInt(COLOR))
            pressMeButton.setBackgroundColor(getInt(COLOR))
        }
    }
}
fun IntArray.getRandomElement()=this[(Math.random()*this.size).toInt()]
fun <T>Array<T>.getRandomElement()=this[(Math.random()*this.size).toInt()]