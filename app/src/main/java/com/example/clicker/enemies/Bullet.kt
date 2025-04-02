package com.example.clicker.enemies

import android.graphics.Color
import com.example.clicker.MainActivity
import com.example.clicker.enemies.mylib.ScreenObject
import kotlin.math.sqrt


class Bullet(x: Float, y: Float, activity: MainActivity,val target: Enemy): ScreenObject(x, y, activity) {
    companion object {
        var width = 25
        var height = width
    }
    val speed = 5.5f

    init {
        createXmlObject(color = Color.WHITE, width = width, height = height, radius = width*0.5f)
    }
    fun move()
    {
        val xd = target.x
        val yd = target.y
        val vectorX: Float = xd-x
        val vectorY: Float = yd-y
        val length = sqrt(vectorX*vectorX + vectorY*vectorY)
        x += vectorX / length * speed
        y += vectorY / length * speed
        xmlObject.x = x
        xmlObject.y = y

    }
}