package com.example.lab6

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private val items = arrayOf("選項 1", "選項 2", "選項 3", "選項 4", "選項 5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        setupWindowInsets()
        setupButtons()
    }

    // 設定邊緣至邊緣佈局
    private fun setupWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // 設定所有按鈕的點擊事件
    private fun setupButtons() {
        findViewById<Button>(R.id.btnToast).setOnClickListener {
            showToast("預設 Toast")
        }

        findViewById<Button>(R.id.btnSnackBar).setOnClickListener {
            showSnackBar(it)
        }

        findViewById<Button>(R.id.btnDialog1).setOnClickListener {
            showAlertDialog("按鈕式 AlertDialog", "AlertDialog 內容", isList = false)
        }

        findViewById<Button>(R.id.btnDialog2).setOnClickListener {
            showAlertDialog("列表式 AlertDialog", "選擇一個項目", isList = true)
        }

        findViewById<Button>(R.id.btnDialog3).setOnClickListener {
            showSingleChoiceDialog()
        }
    }

    // 顯示 Snackbar
    private fun showSnackBar(view: android.view.View) {
        Snackbar.make(view, "按鈕式 Snackbar", Snackbar.LENGTH_SHORT)
            .setAction("按鈕") {
                showToast("已回應")
            }.show()
    }

    // 顯示一般的 AlertDialog
    private fun showAlertDialog(title: String, message: String, isList: Boolean) {
        val builder = AlertDialog.Builder(this).apply {
            setTitle(title)
            setMessage(message)

            if (isList) {
                setItems(items) { _, i ->
                    showToast("你選的是${items[i]}")
                }
            } else {
                setNeutralButton("左按鈕") { _, _ -> showToast("左按鈕") }
                setNegativeButton("中按鈕") { _, _ -> showToast("中按鈕") }
                setPositiveButton("右按鈕") { _, _ -> showToast("右按鈕") }
            }
        }
        builder.show()
    }

    // 顯示單選式 AlertDialog
    private fun showSingleChoiceDialog() {
        var selectedPosition = 0
        AlertDialog.Builder(this)
            .setTitle("單選式 AlertDialog")
            .setSingleChoiceItems(items, selectedPosition) { _, i ->
                selectedPosition = i
            }
            .setPositiveButton("確定") { _, _ ->
                showToast("你選的是${items[selectedPosition]}")
            }
            .show()
    }

    // 顯示 Toast 訊息
    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
