package com.example.lab4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var tvMeal: TextView
    private lateinit var btnSelect: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tvMeal = findViewById(R.id.tv_meal)
        btnSelect = findViewById(R.id.btn_choice)


        
	val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == 101) {
                val data = result.data?.extras
                val str1 = data?.getString("drink")
                val str2 = data?.getString("sugar")
                val str3 = data?.getString("ice")
                tvMeal.text = "飲料: $str1\n\n甜度: $str2\n\n冰塊: $str3"

            }
        }

        btnSelect.setOnClickListener {
            startForResult.launch(Intent(this, Main2Activity::class.java))
        }
    }
}

