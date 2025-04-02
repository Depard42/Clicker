package com.example.clicker

import android.os.Bundle
import android.widget.FrameLayout
import androidx.activity.ComponentActivity
import com.example.clicker.enemies.EnemiesController
import com.example.clicker.enemies.Hero
import kotlinx.coroutines.*


class MainActivity : ComponentActivity() {
    private var loopJob: Job? = null
    private var isActive = false

    lateinit var enemiesController: EnemiesController
    lateinit var hero: Hero

    override fun onCreate(savedInstanceState: Bundle?) {
        // Init
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        // Get main container and settings
        val container: FrameLayout = findViewById(R.id.RelativeLayout)
        val screenWidth = container.context.resources.displayMetrics.widthPixels
        // Init main controllers
        enemiesController = EnemiesController(this, container, screenWidth)
        enemiesController.createEnemies()
        hero = Hero(x = (screenWidth-Hero.width)*0.5f, y = (screenWidth-Hero.height)*0.5f, this)
        hero.addToScreen(container)


        startLoop()
    }
    fun mainCycle() = runBlocking  {
        withContext(Dispatchers.Main) {
            // Обновление UI
            enemiesController.update()
            hero.update(enemiesController.sortedEnemiesByDistance)
        }

    }
    private fun startLoop() {
        isActive = true
        loopJob = CoroutineScope(Dispatchers.Default).launch {
            while (isActive) {
                // Ваш повторяющийся код здесь
                mainCycle()
                // Задержка
                delay(16)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        stopLoop()
    }

    private fun stopLoop() {
        isActive = false
        loopJob?.cancel()
    }

}