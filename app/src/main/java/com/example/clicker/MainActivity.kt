package com.example.clicker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import android.widget.FrameLayout
import android.widget.RelativeLayout
import androidx.activity.ComponentActivity
import kotlin.math.roundToInt
import kotlin.random.Random


class MainActivity : ComponentActivity() {
    val random: Random = Random(1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        val myButton: Button = findViewById(R.id.button)
    }
    override fun onTouchEvent(e: MotionEvent): Boolean {
        if (e.actionMasked != MotionEvent.ACTION_DOWN) {
            return true
        }
        val x: Float = e.x
        val y: Float = e.y
        val myButton: Button = findViewById(R.id.button)
        myButton.text = "$x : $y and hui"//trvfgyhuij
//        myButton.translationX = x
//        myButton.translationY = y
        new_button(x, y)

//        if (y > 1000) {
//            myButton.translationY += 50
//        }
//        if (y <= 1000) {
//            myButton.translationY -= 50
//        }
//        if (x > 500) {
//            myButton.translationX += 50
//        }
//        if (x <= 500) {
//            myButton.translationX -= 50
//        }
        return true
    }
    fun new_button(x: Float, y: Float) {
        val buttonId: Int = random.nextInt()
        val button = Button(this)//Button((activity as MainActivity?)!!)
        button.text = "$buttonId"
        button.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        button.id = buttonId
//        button.top = y.roundToInt()
//        button.left = x.roundToInt()
        button.width = 100
        button.height = 100
        button.x= x
        button.y = y
//        button.setOnClickListener(this)
        val container: FrameLayout = findViewById(R.id.RelativeLayout)
        container.addView(button)
    }
}