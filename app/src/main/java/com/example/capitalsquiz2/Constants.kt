package com.example.capitalsquiz2

import android.graphics.drawable.Drawable
import android.media.Image
import android.widget.ImageView

object Constants {
    const val score: String = "score"
    fun provideQuestions(): List<Question> {
        val questions = mutableListOf<Question>()
         questions.add(
             Question(
                 id = 0,
                 question = R.drawable.paris ,
                 name = "Paris",
                 answers = listOf("Franciya" , "Russia" , "Great Britain" , "Argentina"),
                 correctAnswerId = 0
             )
         )
        questions.add(
            Question(
                id = 0,
                question = R.drawable.buenos_aires,
                name = "Buenos aires",
                answers = listOf("Australia" , "Argentina" , "USA" , "CHina"),
                correctAnswerId = 1
            )
        )
        questions.add(
            Question(
                id = 0,
                question = R.drawable.dublin,
                name = "Dublin",
                answers = listOf("Irland" , "England" , "Spain" , "Japan"),
                correctAnswerId = 0
            )
        )
        questions.add(
            Question(
                id = 0,
                question = R.drawable.seul,
                name = "Seul",
                answers = listOf("Uzbekistan" , "UAE" , "Korea" , "Switzerland"),
                correctAnswerId = 2
            )
        )
        questions.add(
            Question(
                id = 0,
                question = R.drawable.rio,
                name = "Rio de Janeiro",
                answers = listOf("Tailand" , "Portugal" , "Brazil" , "Kazakhstan"),
                correctAnswerId = 2
            )
        )
        questions.add(
            Question(
                id = 0,
                question = R.drawable.bishkek,
                name = "Bishkek",
                answers = listOf("Israel" , "Singapure" , "Canada" , "Kyrgyzstan"),
                correctAnswerId = 3
            )
        )
        questions.add(
            Question(
                id = 0,
                question = R.drawable.berlin,
                name = "Berlin",
                answers = listOf("Italy" , "Germany" , "Korea" , "Russia"),
                correctAnswerId = 1
            )
        )
        questions.add(
            Question(
                id = 0,
                question = R.drawable.almati,
                name = "Almatı",
                answers = listOf("Kongo" , "Mexico" , "Scotland" , "Kazakhstan"),
                correctAnswerId = 3
            )
        )
        questions.add(
            Question(
                id = 0,
                question = R.drawable.venice,
                name = "Venice",
                answers = listOf("Italy" , "Austriya" , "Poland" , "Paris"),
                correctAnswerId = 0
            )
        )
        questions.add(
            Question(
                id = 0,
                question = R.drawable.manshestr,
                name = "Manchestr",
                answers = listOf("Belgium" , "England" , "Romania" , "Croatia"),
                correctAnswerId = 1
            )
        )

        return questions
    }
}