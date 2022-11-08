package com.example.capitalsquiz2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.capitalsquiz2.databinding.ActivityGameBinding
import com.example.capitalsquiz2.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val score = intent.getStringExtra(Constants.score)
        val totalQuestion = intent.getStringExtra("total size")

        binding.apply {
            "$score / $totalQuestion \n".also { RightAnswer.text = it }

        }

        binding.newgame.setOnClickListener {
            val intent = Intent(this , GameActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.exit.setOnClickListener {
            val intent = Intent(this,ResultActivity::class.java)
            finish()
        }
    }
}