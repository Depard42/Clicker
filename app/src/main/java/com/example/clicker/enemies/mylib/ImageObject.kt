package com.example.clicker.enemies.mylib

import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.RelativeLayout
import com.example.clicker.MainActivity


open class ImageObject(var x: Float, var y: Float, val activity: MainActivity, val container: FrameLayout) {
    val xmlObject = RelativeLayout(activity)
    private val imageView = ImageView(activity)
    open var img = 0

    fun createXmlObject(width: Int, height: Int) {
        imageView.setImageResource(img); // укажите ваше изображение
        xmlObject.layoutParams = RelativeLayout.LayoutParams(width, height)
        container.addView(xmlObject)
        xmlObject.addView(imageView)
        xmlObject.x = x
        xmlObject.y = y
    }
    fun removeFromScreen()
    {
        container.removeView(xmlObject)
    }
}