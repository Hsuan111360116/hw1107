package com.example.lab5

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    private fun logLifecycle(event: String) = Log.e("MainActivity", event)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.e("MainActivity","onCreate")

        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)

        val adapter = ViewPagerAdapter(supportFragmentManager, this.lifecycle)
        viewPager2.adapter = adapter

        viewPager2.offscreenPageLimit = 1
    }

    override fun onRestart() { super.onRestart(); logLifecycle("onRestart") }
    override fun onStart() { super.onStart(); logLifecycle("onStart") }
    override fun onResume() { super.onResume(); logLifecycle("onResume") }
    override fun onPause() { super.onPause(); logLifecycle("onPause") }
    override fun onStop() { super.onStop(); logLifecycle("onStop") }
    override fun onDestroy() { super.onDestroy(); logLifecycle("onDestroy") }
}