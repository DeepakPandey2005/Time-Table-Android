package com.time_table

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val mon = findViewById<CardView>(R.id.mon)
        val tue = findViewById<CardView>(R.id.tue)
        val wed = findViewById<CardView>(R.id.wed)
        val thu = findViewById<CardView>(R.id.thu)
        val fri = findViewById<CardView>(R.id.fri)
        val sat = findViewById<CardView>(R.id.sat)
        val todo = findViewById<LinearLayout>(R.id.Todo)
        mon.setOnClickListener {
            openDayActivity("monday")
        }
        tue.setOnClickListener {
            openDayActivity("tuesday")
        }
        wed.setOnClickListener {
            openDayActivity("wednesday")
        }
        thu.setOnClickListener {
            openDayActivity("thursday")
        }
        fri.setOnClickListener {
            openDayActivity("friday")
        }
        sat.setOnClickListener {
            openDayActivity("saturday")
        }
        todo.setOnClickListener {
            openDayActivity("todo")
        }
    }

    private fun openDayActivity(day: String) {
        val intent = Intent(this, ShowTT::class.java)  // Correct way to create an intent
        intent.putExtra("DAY", day)
        startActivity(intent)
    }
}