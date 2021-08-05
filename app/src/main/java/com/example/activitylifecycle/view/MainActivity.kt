package com.example.activitylifecycle.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.activitylifecycle.Model.QuestionModel
import com.example.activitylifecycle.R
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var qModel : QuestionModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //qModel = ViewModelProvider(this).get(QuestionModel::class.java)
        qModel  = QuestionModel.getInstance() //getInstance() from QuestionModel

        val btn : Button = findViewById(R.id.btnNext)

        btn.setOnClickListener(){
            var intent : Intent = Intent(this, SecondActivity::class.java )

            qModel.name = findViewById<TextView>(R.id.tfName).text.toString() //get from text field

            startActivity(intent)
        }
    }
}