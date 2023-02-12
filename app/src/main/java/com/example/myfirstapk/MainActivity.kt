package com.example.myfirstapk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var isPlayer1 = true
    var gameEnd = false
    private lateinit var Top: ImageView
    private lateinit var TopEnd: ImageView
    private lateinit var Topstart: ImageView

    private lateinit var center: ImageView
    private lateinit var centerstart: ImageView
    private lateinit var centerEnd: ImageView

    private lateinit var Bottom: ImageView
    private lateinit var BottomEnd: ImageView
    private lateinit var Bottomstart: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        centerstart = findViewById(R.id.centerstart)
        center = findViewById(com.google.android.material.R.id.center)
        centerEnd = findViewById(R.id.centerEnd)

        Top = findViewById(R.id.top)
        TopEnd = findViewById(R.id.topend)
        Topstart = findViewById(R.id.topstart)

        Bottom = findViewById(R.id.back)
        Bottomstart = findViewById(R.id.backstart)
        BottomEnd = findViewById(R.id.backend)
        val reset : Button = findViewById(R.id.button_reset)
        reset.setOnClickListener {
            resetBox(center)
            resetBox(centerEnd)
            resetBox(centerstart)

            resetBox(Top)
            resetBox(Topstart)
            resetBox(TopEnd)

            resetBox(Bottom)
            resetBox(BottomEnd)
            resetBox(Bottomstart)
        }


        configureBox(center)
        configureBox(centerEnd)
        configureBox(centerstart)

        configureBox(Top)
        configureBox(Topstart)
        configureBox(TopEnd)

        configureBox(Bottom)
        configureBox(BottomEnd)
        configureBox(Bottomstart)
    }
    private fun resetBox(box: ImageView) {
        box.setImageDrawable(null)
        box.tag = null
        isPlayer1 = true
        gameEnd = false
    }
    private fun configureBox(box: ImageView) {
        box.setOnClickListener {
            if (box.tag == null && !gameEnd) {
                if (isPlayer1) {
                    box.setImageResource(R.drawable.ic_baseline_panorama_fish_eye_24)
                    isPlayer1 = false
                    box.tag = 1
                } else {
                    box.setImageResource(R.drawable.ic_baseline_close_24)
                    isPlayer1 = true
                    box.tag = 2
                }
                if (playerWin(1)) {
                    Toast.makeText(this@MainActivity, "player 1 venceu!", Toast.LENGTH_SHORT).show()
                    gameEnd = true
                }else if (playerWin(2)) {
                    Toast.makeText(this@MainActivity,"player 2 venceu!", Toast.LENGTH_SHORT).show()
                    gameEnd = true
                }
            }
        }
    }
    private fun playerWin(value: Int): Boolean {
        if ( (Top.tag == value && center.tag == value && Bottom.tag == value) ||
            (Topstart.tag == value && centerstart.tag == value && Bottomstart.tag == value) ||
             (TopEnd.tag == value && centerEnd.tag == value && BottomEnd.tag == value) ||

            (Topstart.tag == value && Top.tag == value && TopEnd.tag == value) ||
            (centerstart. tag == value && center.tag == value && centerEnd.tag == value) ||
            (Bottomstart.tag == value && Bottom.tag == value && BottomEnd.tag == value) ||

            (Topstart.tag == value && center.tag == value && BottomEnd.tag == value) ||
            (TopEnd.tag == value && center.tag == value && Bottomstart.tag == value)


                ) {
            return true
        }
        return false
    }
}

