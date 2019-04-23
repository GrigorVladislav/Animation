package com.example.testanimation

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF

class Ball() {

    private var ballRadius:Float = 0F
    private var ballX = ballRadius + ballRadius/4
    private var ballY = ballRadius + ballRadius/2
    private var ballSpeedX = 0F
    private var ballSpeedY = 0F
    lateinit var ballBounds : RectF
    private val paint = Paint()

    constructor(ballX: Float, ballY:Float,radius:Float, alpha:Int, red:Int, green:Int, blue:Int) : this(){
        this.ballX = ballX
        this.ballY=ballY
        ballRadius = radius

        ballBounds = RectF()

        setColor(alpha,red,green,blue)
    }

    constructor(ballX: Float, ballY:Float,radius:Float, ballSpeedX:Float, ballSpeedY:Float, alpha:Int, red:Int, green:Int, blue:Int) : this(){
        this.ballX = ballX
        this.ballY=ballY
        ballRadius = radius
        this.ballSpeedX = ballSpeedX
        this.ballSpeedY = ballSpeedY
        ballBounds = RectF()

        setColor(alpha,red,green,blue)
    }

    fun setColor(alpha:Int, red:Int, green:Int, blue:Int){
        paint.setARGB(alpha, red, green, blue)
    }

    fun setBallSpeed(speedX:Float, speedY:Float){
        this.ballSpeedX = speedX
        this.ballSpeedY = speedY
    }

    fun update(xMin:Float, xMax:Float, yMin:Float, yMax:Float){
        this.ballX += this.ballSpeedX
        this.ballY += this.ballSpeedY

        if (ballX + ballRadius > xMax){
            ballSpeedX = -ballSpeedX
            ballX = xMax - ballRadius
        }else if (ballX - ballRadius < xMin){
            ballSpeedX = -ballSpeedX
            ballX = xMin + ballRadius
        }

        if (ballY + ballRadius > yMax){
            ballSpeedY = -ballSpeedY
            ballY = yMax - ballRadius
        }else if (ballY - ballRadius < yMin){
            ballSpeedY = -ballSpeedY
            ballY = yMin + ballRadius
        }
    }

    fun draw(canvas: Canvas){
        ballBounds.set(ballX-ballRadius, ballY - ballRadius, ballX + ballRadius, ballY + ballRadius)
        canvas.drawOval(ballBounds, paint)
    }

}