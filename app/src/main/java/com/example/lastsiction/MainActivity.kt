package com.example.lastsiction

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.lastsiction.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ربط الـ ViewModel بالـ Binding
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        // تحديث واجهة المستخدم عند تغير القيم
        viewModel.team1Score.observe(this) { score ->
            binding.team1Score.text = score.toString()
        }

        viewModel.team2Score.observe(this) { score ->
            binding.team2Score.text = score.toString()
        }

        binding.showResult.setOnClickListener {
            viewModel.showResult()
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("WINNER_MESSAGE", viewModel.resultMessage.value)
            startActivity(intent)
        }
    }
}
