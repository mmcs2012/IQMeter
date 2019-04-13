package com.mmcs.iqmeter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var text = inputField.text
        startButton.setOnClickListener{
            if (text.isEmpty()) resultTextView.text = "Введите текст"
            else resultTextView.text = "Привет, $text"
        }
    }
}
