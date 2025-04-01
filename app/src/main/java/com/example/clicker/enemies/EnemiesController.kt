package com.example.clicker.enemies
import android.widget.FrameLayout
import com.example.clicker.MainActivity
import java.util.Vector
import kotlin.random.Random

class EnemiesController(val activity: MainActivity, val container: FrameLayout) {
    val width = 1000
    val height = 2000
    val enemies = mutableListOf<Enemy>()
    fun createEnemies()
    {
        val random= Random(1)
        for (i in 0..100){
            val enemy = Enemy( x = random.nextFloat()*width, y = random.nextFloat()*height, activity)
            enemy.createXmlObject()
            enemy.addEnemyToScreen(container)
            enemies.add(enemy)
        }
    }
    fun update()
    {
        for (enemy in enemies.iterator())
        {
            enemy.move(500f, 500f)
        }
    }
}