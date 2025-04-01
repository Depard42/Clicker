package com.example.clicker

import android.os.Bundle
import android.widget.FrameLayout
import androidx.activity.ComponentActivity
import com.example.clicker.enemies.EnemiesController
import kotlinx.coroutines.*


class MainActivity : ComponentActivity() {
    private var loopJob: Job? = null
    private var isActive = false

    lateinit var enemiesController: EnemiesController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        val container: FrameLayout = findViewById(R.id.RelativeLayout)
        enemiesController = EnemiesController(this, container)
        enemiesController.createEnemies()

        startLoop()
    }
    fun mainCycle() = runBlocking  {
        withContext(Dispatchers.Main) {
            // Обновление UI
            enemiesController.update()
//            val container: FrameLayout = findViewById(R.id.RelativeLayout)
//            container.x += 10
        }

    }
    private fun startLoop() {
        isActive = true
        loopJob = CoroutineScope(Dispatchers.Default).launch {
            while (isActive) {
                // Ваш повторяющийся код здесь
                mainCycle()

                // Задержка перед следующей итерацией (например, 1 секунда)
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