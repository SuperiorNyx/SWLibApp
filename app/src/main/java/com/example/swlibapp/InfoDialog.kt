package com.example.swlibapp

import android.app.Activity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.swlibrary.Categories.*


class InfoDialog : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_dialog)
        val textView : TextView = findViewById(R.id.textView)
        val button : Button = findViewById(R.id.button2)
        button.setOnClickListener {
            closeWindow()
        }

        if(intent.extras != null) {
            when(intent.getStringExtra("type")) {
                "person" -> {
                    val data = intent.getParcelableExtra<Person>("Data")
                    textView.text = data!!.toString()
                }
                "film" -> {
                    val data = intent.getParcelableExtra<Film>("Data")
                    textView.text = data!!.toString()
                }
                "planet" -> {
                    val data = intent.getParcelableExtra<Planet>("Data")
                    textView.text = data!!.toString()
                }
                "species" -> {
                    val data = intent.getParcelableExtra<Species>("Data")
                    textView.text = data!!.toString()
                }
                "starship" -> {
                    val data = intent.getParcelableExtra<Starship>("Data")
                    textView.text = data!!.toString()
                }
                "vehicle" -> {
                    val data = intent.getParcelableExtra<Vehicle>("Data")
                    textView.text = data!!.toString()
                }
                else -> {
                    Toast.makeText(this, "Can\'t find info!", Toast.LENGTH_SHORT).show()
                }
            }
            textView.movementMethod = ScrollingMovementMethod()
        }
    }

    fun closeWindow(){
        finish()
    }
}