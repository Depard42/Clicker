package com.example.clicker.enemies.mylib

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.View
import android.widget.FrameLayout
import com.example.clicker.MainActivity

open class ScreenObject(var x: Float, var y: Float, val activity: MainActivity, val container: FrameLayout) {
    val xmlObject = View(activity)

    fun createXmlObject(color: Int,
                        width: Int,
                        height: Int,
                        strokeWidth: Int = 0,
                        strokeColor: Int = Color.BLACK,
                        shapeFigure: Int = GradientDrawable.RECTANGLE,
                        radius: Float = 0f)
    {
        xmlObject.apply {
            layoutParams = FrameLayout.LayoutParams(width,height)
            background = GradientDrawable().apply {
                shape = shapeFigure
                setColor(color)
                cornerRadius = radius
                setStroke(strokeWidth, strokeColor)
            }
        }
        xmlObject.id =  View.generateViewId()
        xmlObject.x = x
        xmlObject.y = y

        addToScreen()
    }

    fun addToScreen()
    {
        container.addView(xmlObject)
    }
    fun removeFromScreen()
    {
        container.removeView(xmlObject)
    }
}