package com.example.testanimation

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import java.lang.Exception

class BouncingBallView(context: Context,attrs:AttributeSet? = null):View(context,attrs) {
//class BouncingBallView@JvmOverloads constructor(
//    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : View(context, attrs, defStyleAttr){

    private var xMin = 0f
    private var xMax = 0f
    private var yMin = 0f
    private var yMax = 0f
    private val balls = mutableListOf<Ball>()

    constructor(context: Context) : this(context, null) {
       for (i in 1..150 step 1){
           balls.add(addBall())
       }
    }

    fun addBall ():Ball{

        var red : Int = (5 + (Math.random()*(255-5))).toInt()
        var green = (5 + (Math.random()*(255-5))).toInt()
        var blue= (5 + (Math.random()*(255-5))).toInt()
        var velX =(1 + (Math.random()*20)).toFloat()
        var velY =(1 + (Math.random()*20)).toFloat()
        val radius = (2 + (Math.random()*50)).toFloat()

        var ball = Ball(0F,0F,radius,velX,velY,255,red,green,blue)
        return ball
    }

    override fun onDraw(canvas: Canvas?) {
        for (i in 1..balls.size-1 step 1){
            balls.get(i).draw(canvas!!)
        }
        for (i in 1..balls.size-1 step 1){
            balls.get(i).update(xMin,xMax,yMin,yMax)

        }
        try {
            Thread.sleep(20)

        }catch (e:Exception){

        }
        invalidate()

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        xMax = (w-1).toFloat()
        yMax = (h-1).toFloat()
    }

}