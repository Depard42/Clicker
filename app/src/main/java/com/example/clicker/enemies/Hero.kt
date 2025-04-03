package com.example.clicker.enemies

import android.widget.FrameLayout
import com.example.clicker.MainActivity
import com.example.clicker.enemies.mylib.ScreenObject
import com.example.clicker.enemies.colors.*
import kotlin.collections.iterator
import kotlin.system.*
import kotlin.time.*
import com. example. clicker.R
import com.example.clicker.enemies.mylib.ImageObject

class Hero(x: Float, y: Float, activity: MainActivity, container: FrameLayout): ImageObject(x, y, activity, container){
    companion object {
        var width = 200
        var height = 200
    }
    override var img: Int = R.drawable.hero
    val bullets = mutableListOf<Bullet>()
    var range = 360f
    private var lastShootTime: Long = 0

    init {
        val distanceOfRange = ScreenObject(x-range+width*0.5f, y-range+height*0.5f, activity, container)
        distanceOfRange.createXmlObject(color = RangeColor, width = (2*range).toInt(), height=(2*range).toInt(), radius = range, strokeWidth = 20, strokeColor = RangeStrokeColor)
        createXmlObject(width, height)

        }

    fun update(sortedEnemiesByDistance: List<Enemy>) {
        for (bullet in bullets.iterator())
        {
            bullet.move()
        }
        bullets.removeAll { it.isDelete }

        val currentTime = System.currentTimeMillis()
        if (currentTime - lastShootTime > 300) {
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