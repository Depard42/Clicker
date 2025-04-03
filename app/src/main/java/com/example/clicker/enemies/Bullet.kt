package com.example.clicker.enemies

import android.graphics.Color
import android.widget.FrameLayout
import com.example.clicker.MainActivity
import com.example.clicker.enemies.mylib.ScreenObject
import kotlin.math.sqrt


class Bullet(x: Float, y: Float, activity: MainActivity,val target: Enemy, container: FrameLayout): ScreenObject(x, y, activity, container) {
    companion object {
        var width = 26
        var height = width
    }
    val speed = 10f
    var damage = 100f
    var isDelete = false

    init {
        createXmlObject(color = Color.WHITE, width = width, height = height, radius = width*0.5f)
    }
    fun move()
    {
        if (target.health > 0) {
            val xd = target.x
            val yd = target.y
            val vectorX: Float = xd - x
            val vectorY: Float = yd - y
            val length = sqrt(vectorX * vectorX + vectorY * vectorY)

            if (length < width) {
                // Попал!
                target.getDamage(damage)
                removeFromScreen()
                isDelete = true
            }
            else{
                // Летим дальше
                x += vectorX / length * speed
                y += vectorY / length * speed
                xmlObject.x = x
                xmlObject.y = y
            }

        } else {
            // Враг уже мёртв
            removeFromScreen()
            isDelete = true
        }

    }
}