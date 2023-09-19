package com.example.coding_made_fun.data

import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.coding_made_fun.model.Question
import com.example.coding_made_fun.navigation.ROUTE_REGISTER
import com.example.coding_made_fun.navigation.ROUT_LOGIN

class QuizViewModel : ViewModel() {


    // Hardcoded list of quiz questions
    private val quizQuestions = listOf(
        Question(
            id = 1,
            questionText = "What is the capital of France?",
            options = listOf("London", "Berlin", "Paris", "Madrid"),
            correctAnswer = 2 // Index of the correct answer in the options list
        ),
        // Add more questions here
        Question(
            id = 2,
            questionText = "What is the capital of kenya",
            options = listOf("meru", "mombasa", "nairobi", "kisumu"),
            correctAnswer = 3 // Index of the correct answer in the options list
        ),
    )

    private var currentQuestionIndex = 0
    private var score = 0

    fun getCurrentQuestion(): Question {
        return quizQuestions[currentQuestionIndex]
    }

    fun checkAnswer(selectedOptionIndex: Int): Boolean {
        val currentQuestion = getCurrentQuestion()
        if (selectedOptionIndex == currentQuestion.correctAnswer) {
            score++
            return true
        }
        return false
    }

    fun moveToNextQuestion() {
        currentQuestionIndex++
    }

    fun isQuizFinished(): Boolean {
        return currentQuestionIndex >= quizQuestions.size

    }

    fun getScore(): Int {
        return score
    }
    fun getTotalQuestions(): Int {
        return quizQuestions.size
    }
}
