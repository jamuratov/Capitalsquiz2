package com.example.capitalsquiz2

import android.media.Image
import androidx.annotation.DrawableRes

data class Question(
    val id: Int,
    @DrawableRes val question: Int,
    val name: String,
    val answers: List<String>,
    val correctAnswerId: Int,
)
