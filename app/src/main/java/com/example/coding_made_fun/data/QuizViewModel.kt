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
            questionText = "What is a computer?",
            options = listOf("A computer is a machine that processes information, performs tasks, and stores data",
                "A computer is a magical electronic box that runs on a diet of coffee and unicorn tears",
                "A computer is a device used to take pictures ", "A computer is a Time Machine"),
            correctAnswer = 0 // Index of the correct answer in the options list
        ),
        // Add more questions here
        Question(
            id = 2,
            questionText = "What do you think the word code means?",
            options = listOf("Code is a secret language only known to hackers", "Code is just a bunch of random characters",
                    "A code is a set of instructions or rules that a computer can understand and follow to perform a specific task or solve a problem",
                "Code is just a bunch of random characters"),
            correctAnswer = 2 // Index of the correct answer in the options list
        ),
        // Add more questions here
        Question(
            id = 3,
            questionText = "Which of the following is not a programming language?",
            options = listOf("Python", "C", "English", "Java"),
            correctAnswer = 2 // Index of the correct answer in the options list
        ),
        // Add more questions here
        Question(
            id = 4,
            questionText = " Can you write a C program that prints Hello, World! to the screen?",
            options = listOf("print(Hello, World!)", "printf(Hello, World!)", "println(Hello, World!)", "printf(Hello World)"),
            correctAnswer = 1 // Index of the correct answer in the options list
        ),
        Question(
            id = 5,
            questionText = "What does IDE stand for?",
            options = listOf("Internet Download Enhancer", "Integrated Development Environment", "Invasive Data Encryption", "Intelligent Data Extraction"),
            correctAnswer = 1 // Index of the correct answer in the options list
        ),
        Question(
            id = 6,
            questionText = "Who is a Software Engineer?",
            options = listOf("Someone who designs buildings using software tools",
                "An individual who operates a software store", "A person who repairs computer hardware",
                "A software engineer is a professional who designs, develops, and maintains computer software and applications."),
            correctAnswer = 3 // Index of the correct answer in the options list
        ),
        Question(
            id = 7,
            questionText = "Who is a FullStack Software Developer?",
            options = listOf("someone who has expertise in both front-end and back-end development",
                "A technician responsible for maintaining a full stack of pancakes at a restaurant",
                "A developer who only works with front-end technologies and has nothing to do with back-end development",
                "Someone who manages the inventory of all physical hardware used in a software development project"),
            correctAnswer = 0 // Index of the correct answer in the options list
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
        return currentQuestionIndex == quizQuestions.size - 1

    }

    fun getScore(): Int {
        return score
    }
    fun getTotalQuestions(): Int {
        return quizQuestions.size
    }
}
