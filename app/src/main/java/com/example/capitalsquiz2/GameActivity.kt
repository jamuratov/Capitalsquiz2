package com.example.capitalsquiz2

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toDrawable
import androidx.core.graphics.toColor
import com.example.capitalsquiz2.databinding.ActivityGameBinding
import com.google.android.material.snackbar.Snackbar

class GameActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityGameBinding
    private val questions = Constants.provideQuestions()
    private  var currentQuestionId = -1
    private var selectedAnswerId = -1
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        currentQuestionId = 0
        setQuestion()

        binding.apply {
            progressBar.max = questions.size
            btnOptionOne.setOnClickListener {
                optionSelected(btnOptionOne)
                selectedAnswerId = 0
            }

            btnOptionTwo.setOnClickListener {
                optionSelected(btnOptionTwo)
                selectedAnswerId = 1
            }

            btnOptionThree.setOnClickListener {
                optionSelected(btnOptionThree)
                selectedAnswerId = 2
            }

            btnOptionFour.setOnClickListener {
                optionSelected(btnOptionFour)
                selectedAnswerId = 3
            }
            btnSubmit.setOnClickListener {
                btnOptionOne.isEnabled = true
                btnOptionTwo.isEnabled = true
                btnOptionThree.isEnabled = true
                btnOptionFour.isEnabled = true
                when (btnSubmit.text) {
                    getString(R.string.text_submit) -> {
                        checkAnswer()
                    }
                    getString(R.string.finish_text) -> {
                        val intent = Intent(this@GameActivity,ResultActivity::class.java)
                        intent.putExtra(Constants.score , score.toString())
                        intent.putExtra("total size" , questions.size.toString())
                        startActivity(intent)
                        finish()
                    }
                    getString(R.string.continue_text) -> {
                        currentQuestionId++
                        setQuestion()
                    }
                }

            }
        }
    }

    private  fun setQuestion() {
        val currentQuestion = questions[currentQuestionId]
        binding.apply {
            progressBar.progress = currentQuestionId + 1
            tvCounter.text = getString(R.string.question_counter, currentQuestionId+1, questions.size)
            CitiesName.text = currentQuestion.name
            tvQuestion.setImageResource(currentQuestion.question)

            btnOptionOne.text = currentQuestion.answers[0]

            btnOptionTwo.text = currentQuestion.answers[1]

            btnOptionThree.text = currentQuestion.answers[2]

            btnOptionFour.text = currentQuestion.answers[3]

            btnOptionOne.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity , R.color.transparent)
            )
            btnOptionTwo.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity , R.color.transparent)
            )
            btnOptionThree.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity , R.color.transparent)
            )
            btnOptionFour.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity , R.color.transparent)
            )

            btnSubmit.text = getString(R.string.text_submit)

        }
    }
    private fun optionSelected(button: Button){
        binding.apply {
            btnOptionOne.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity , R.color.transparent)
            )
            btnOptionTwo.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity , R.color.transparent)
            )
            btnOptionThree.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity , R.color.transparent)
            )
            btnOptionFour.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity , R.color.transparent)
            )
        }
        button.backgroundTintList = ColorStateList.valueOf(
            ContextCompat.getColor(this , R.color.color_option_selected)
        )
    }

    private fun checkAnswer() {
        val currentQuestion = questions[currentQuestionId]

        if (selectedAnswerId == -1){
            Snackbar.make(
                binding.btnSubmit,
                "Please, select option",
                Snackbar.LENGTH_SHORT
            ).show()
            return
        }

        binding.apply {
            if (currentQuestion.correctAnswerId != selectedAnswerId) {
                ContextCompat.getColor(this@GameActivity , R.color.color_error)
            }
            else{
                score++
            }
            when(selectedAnswerId){
                0 -> {
                    btnOptionOne.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity , R.color.color_error)
                    )
                }
                1 -> {
                    btnOptionTwo.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity , R.color.color_error)
                    )
                }
                2 -> {
                    btnOptionThree.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity , R.color.color_error)
                    )
                }
                3 -> {
                    btnOptionFour.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity , R.color.color_error)
                    )
                }
            }

            when(currentQuestion.correctAnswerId){
                0 -> {
                    btnOptionOne.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity , R.color.color_correct)
                    )
                }
                1 -> {
                    btnOptionTwo.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity , R.color.color_correct)
                    )
                }
                2 -> {
                    btnOptionThree.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity , R.color.color_correct)
                    )
                }
                3 -> {
                    btnOptionFour.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity , R.color.color_correct)
                    )
                }
            }
            if (currentQuestionId != questions.lastIndex){
                btnSubmit.text = getString((R.string.continue_text))
            }
            else {
                btnSubmit.text = getString(R.string.finish_text)
            }
            binding.btnOptionOne.isEnabled = false
            binding.btnOptionTwo.isEnabled = false
            binding.btnOptionThree.isEnabled = false
            binding.btnOptionFour.isEnabled = false

            selectedAnswerId = -1
        }
    }

}