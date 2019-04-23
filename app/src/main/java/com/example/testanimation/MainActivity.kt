package com.example.testanimation

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bouncingBallView = BouncingBallView(this)
        setContentView(bouncingBallView)
        bouncingBallView.setBackgroundColor(Color.BLACK)
    }
}
