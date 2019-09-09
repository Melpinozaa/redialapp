package com.example.redialapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var loadingContainer: View? = null
    var sendButton: Button? = null

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numero0.setOnClickListener { toclear("0", true) }
        numero1.setOnClickListener { toclear("1", true) }
        numero2.setOnClickListener { toclear("2", true) }
        numero3.setOnClickListener { toclear("3", true) }
        numero4.setOnClickListener { toclear("4", true) }
        numero5.setOnClickListener { toclear("5", true) }
        numero6.setOnClickListener { toclear("6", true) }
        numero7.setOnClickListener { toclear("7", true) }
        numero8.setOnClickListener { toclear("8", true) }
        numero9.setOnClickListener { toclear("9", true) }

        borrar.setOnClickListener {
            val string = numberDisplay.text.toString()
            if (string.isNotEmpty()) {
                numberDisplay.text = string.substring(0, string.length - 1)
            }
            numberDisplay.text = ""
        }
        sendButton = findViewById(R.id.llamar)
        sendButton!!.setOnClickListener { showLoading(true) }


        loadingContainer = findViewById(R.id.loadingContainer)
        loadingContainer!!.setOnClickListener { showLoading(false) }
        setActionBar(null)
    }

    fun toclear(string: String, clear: Boolean) {
        if (clear) {
            numberDisplay.append(string)

        } else {
            numberDisplay.append(string)
        }

    }

    fun showLoading(show: Boolean) {
        val visibility = if (show) View.VISIBLE else View.GONE
        loadingContainer!!.visibility = visibility

    }
}
