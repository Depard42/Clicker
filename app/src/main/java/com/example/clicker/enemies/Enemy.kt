package com.example.clicker.enemies

import com.example.clicker.MainActivity
import android.graphics.Color
import android.widget.FrameLayout
import com.example.clicker.R
import com.example.clicker.enemies.mylib.ImageObject
import com.example.clicker.enemies.mylib.ScreenObject
import kotlin.math.sqrt
import kotlin.reflect.KDeclarationContainer


class Enemy(x: Float, y: Float, activity: MainActivity, container: FrameLayout): ImageObject(x, y, activity, container){
    val speed: Float = 1.5f
    var distance: Float = 1000f
    var health: Float = 100f
    override var img: Int = R.drawable.enemy

    init {
        createXmlObject(width = 50, height = 50)
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
    fun getDamage(damage: Float){
        val newHealth = health - damage
        if (health > 0 && newHealth <= 0){
            removeFromScreen()
        }
        health = newHealth
    }
}