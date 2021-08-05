package com.example.activitylifecycle.Model

import androidx.lifecycle.ViewModel

class QuestionModel : ViewModel() { //extend ViewModel
    var name : String = "" //example, actually need to open new model
    var no1 : Int = 0
    var no2 : Int = 0

    companion object { //static variable
        private var instance : QuestionModel? = null

        fun getInstance () =
            instance?: synchronized(QuestionModel::class.java) {
                instance?: QuestionModel().also { instance = it }
            }
    }

    init {
        generateQuestion()
    }

    fun getAnswer() : Int {
        return no1 + no2
    }

    fun generateQuestion() : String{
        no1 = (Math.random()*100).toInt() //the number generate is from 0 - 99
        no2 = (Math.random()*100).toInt()

        return "${no1} + ${no2} = ?"
    }

    fun getQuestion() : String {
        return "${no1} + ${no2} = ?"
    }


}