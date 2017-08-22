package com.pablo384.magicball

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //1- clic listener
        //2- generar un color aleatorio
        //3- generar una frase aleatoria

        pressMeButton.setOnClickListener {
            val randomColor= getRandomColor()
        }
    }

    private fun getRandomColor(): Int {
        val colors = intArrayOf(Color.CYAN, Color.RED, Color.MAGENTA, Color.GREEN, Color.BLACK)
        val random = (Math.random()*colors.size).toInt()
        return colors[random]
    }
}
