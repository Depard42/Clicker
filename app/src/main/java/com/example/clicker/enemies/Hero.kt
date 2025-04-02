package com.example.clicker.enemies

import android.graphics.Color
import android.widget.FrameLayout
import com.example.clicker.MainActivity
import com.example.clicker.R
import com.example.clicker.enemies.mylib.ScreenObject
import kotlin.collections.iterator
import kotlin.system.*
import kotlin.time.*

class Hero(x: Float, y: Float, activity: MainActivity): ScreenObject(x, y, activity){
    companion object {
        var width = 100
        var height = 100
    }
    val bullets = mutableListOf<Bullet>()
    private var lastShootTime: Long = 0

    init {
        createXmlObject(color = Color.YELLOW, width = width, height = height, radius = 16f)
    }

    fun update(sortedEnemiesByDistance: List<Enemy>) {
        for (bullet in bullets.iterator())
        {
            bullet.move()
        }

        val currentTime = System.currentTimeMillis()
        if (currentTime - lastShootTime > 150) {
            if (sortedEnemiesByDistance.isNotEmpty()) {
                val bullet = Bullet(x+width*0.5f, y+height*0.5f, activity, sortedEnemiesByDistance[0])
                bullet.addToScreen(activity.findViewById<FrameLayout>(R.id.RelativeLayout))
                bullets.add(bullet)
            }
            lastShootTime = currentTime
        }


    }
}