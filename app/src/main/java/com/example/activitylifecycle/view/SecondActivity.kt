package com.example.activitylifecycle.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.activitylifecycle.Model.QuestionModel
import com.example.activitylifecycle.R

//same as extend in java (A extends B)
class SecondActivity : AppCompatActivity() {

    private lateinit var qModel : QuestionModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.i("Lifecycle", "onCreate")

        val btn : Button = findViewById(R.id.btnAdd)
        val tvQuestion : TextView = findViewById(R.id.tvQuestion)
        val tvName : TextView = findViewById(R.id.tvName)

        //tvQuestion.text = savedInstanceState.getString("question") //refer back to the question at the bottom onSaveInstanceState

        //if (savedInstanceState != null)
        //   tvQuestion.text = savedInstanceState.getString("question")

        //qModel = QuestionModel()
        //qModel = ViewModelProvider(this).get(QuestionModel::class.java)

        qModel  = QuestionModel.getInstance() //getInstance() from QuestionModel

        tvQuestion.text = qModel.getQuestion()
        tvName.text = qModel.name //get the name from the model

        btn.setOnClickListener(){
            tvQuestion.text = qModel.generateQuestion()
        }
    }

    override fun onStart() {
        super.onStart()

        Log.i("Lifecycle", "onStart")
    }

    override fun onRestart() {
        super.onRestart()

        Log.i("Lifecycle", "onRestart")
    }

    override fun onResume() {
        super.onResume()

        Log.i("Lifecycle", "onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.i("Lifecycle", "onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.i("Lifecycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("Lifecycle", "onDestroy")
    }

    /*override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        var question = findViewById<TextView>(R.id.tvQuestion).text.toString()

        outState.putString("question", question)
    }*/

    /*fun generateQuestion() : String{
        var no1 = (Math.random()*100).toInt()
        var no2 = (Math.random()*100).toInt()

        return "${no1} + ${no2} = ?"
    }*/

}