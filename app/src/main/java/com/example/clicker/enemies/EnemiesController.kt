package com.example.clicker.enemies
import android.widget.FrameLayout
import com.example.clicker.MainActivity
import kotlin.random.Random

class EnemiesController(val activity: MainActivity, val container: FrameLayout, val width: Int) {
    //val width = 1000
    val height = 2000
    val enemies = mutableListOf<Enemy>()
    val spawnQuantity = 50

    lateinit var sortedEnemiesByDistance: List<Enemy>

    fun createEnemies()
    {
        val random= Random(1)
        for (i in 0..spawnQuantity){
            val enemy = Enemy( x = random.nextFloat()*width, y = random.nextFloat()*height+2000, activity)

            enemy.addToScreen(container)
            enemies.add(enemy)
        }
    }
    fun update()
    {
        for (enemy in enemies.iterator())
        {
            enemy.move(500f, 500f)
        }
        sortedEnemiesByDistance = enemies.sortedBy { it.distance }
    }
}