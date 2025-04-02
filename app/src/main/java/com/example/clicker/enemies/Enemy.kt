package com.example.clicker.enemies

import com.example.clicker.MainActivity
import android.graphics.Color
import com.example.clicker.enemies.mylib.ScreenObject
import kotlin.math.sqrt



class Enemy(x: Float, y: Float, activity: MainActivity): ScreenObject(x, y, activity){
    val speed: Float = 2f
    var distance: Float = 1000f

    init {
        createXmlObject(color = Color.RED, width = 50, height = 50, radius = 16f)
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

        distance = length
    }
}