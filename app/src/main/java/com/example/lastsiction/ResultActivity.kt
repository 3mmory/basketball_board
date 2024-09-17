package com.example.lastsiction

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val winnerMessage = intent.getStringExtra("WINNER_MESSAGE")
        val winnerTextView: TextView = findViewById(R.id.winnerTextView)
        winnerTextView.text = winnerMessage ?: "No winner"
    }
}
