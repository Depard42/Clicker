package com.example.clicker.enemies

import android.graphics.drawable.GradientDrawable
import android.view.View
import android.widget.FrameLayout
import com.example.clicker.MainActivity
import android.graphics.Color
import android.widget.Button
import com.example.clicker.R
import kotlin.math.sqrt


class Enemy(var x: Float, var y: Float, val activity: MainActivity ) {
    val xmlObject = View(activity)
    val speed: Float = 2f

    fun createXmlObject()
    {
        xmlObject.apply {
            layoutParams = FrameLayout.LayoutParams(50, 50)
            background = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                setColor(Color.RED)
                cornerRadius = 16f
                setStroke(2, Color.BLACK)
            }
        }
        xmlObject.id =  View.generateViewId()
        xmlObject.x = x
        xmlObject.y = y
    }
    fun addEnemyToScreen(container: FrameLayout)
    {
        container.addView(xmlObject)
    }
    fun move(xd: Float, yd: Float)
    {
        val vectorX: Float = xd-x
        val vectorY: Float = yd-y
        val length = sqrt(vectorX*vectorX + vectorY*vectorY)
        x += vectorX / length * speed
        y += vectorY / length * speed
        xmlObject.x = x
        xmlObject.y = y
    }
}