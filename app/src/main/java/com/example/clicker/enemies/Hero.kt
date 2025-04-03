package com.example.clicker.enemies

import android.graphics.Color
import android.widget.FrameLayout
import com.example.clicker.MainActivity
import com.example.clicker.enemies.mylib.ScreenObject
import kotlin.collections.iterator
import kotlin.system.*
import kotlin.time.*

class Hero(x: Float, y: Float, activity: MainActivity, container: FrameLayout): ScreenObject(x, y, activity, container){
    companion object {
        var width = 100
        var height = 100
    }
    val bullets = mutableListOf<Bullet>()
    var range = 500f
    private var lastShootTime: Long = 0

    init {
        val distanceOfRange = ScreenObject(x-range+width*0.5f, y-range+height*0.5f, activity, container)
        distanceOfRange.createXmlObject(color = Color.GRAY, width = (2*range).toInt(), height=(2*range).toInt(), radius = range, strokeWidth = 3, strokeColor = Color.BLACK)

        createXmlObject(color = Color.YELLOW, width = width, height = height, radius = 16f)
        }

    fun update(sortedEnemiesByDistance: List<Enemy>) {
        for (bullet in bullets.iterator())
        {
            bullet.move()
        }
        bullets.removeAll { it.isDelete }

        val currentTime = System.currentTimeMillis()
        if (currentTime - lastShootTime > 100) {
            if (sortedEnemiesByDistance.isNotEmpty()) {
                val target: Enemy = sortedEnemiesByDistance[0]
                if (target.distance <= range) {
                    val bullet =
                        Bullet(x + width * 0.5f, y + height * 0.5f, activity, target, container)
                    bullets.add(bullet)
                    lastShootTime = currentTime
                }
            }

        }
    }
}