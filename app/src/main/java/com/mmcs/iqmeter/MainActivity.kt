package com.mmcs.iqmeter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        startButton.setOnClickListener{
            if (inputField.text.isEmpty()) resultTextView.text = "@string/no_text" //Если поле ввода пусто - предупреждаем пользователя
            var iqNumber = inputField.text.toString().toIntOrNull() //Объявим и инициализируем переменную целым значением
            when (iqNumber) {
                in 1..10 -> resultTextView.text = "Да уж, $iqNumber... Вам есть куда развиваться. Вы слегка умнее рыбки."
                in 11..25 -> resultTextView.text = "Где-то на уровне домашнего кота. Теперь Вы можете разговаривать с ним на равных."
                in 26..80 -> resultTextView.text = "Поздравляю! Вы умнее наглого домашнего кота. Правда ему плевать на это."
                else -> resultTextView.text = "Вы настолько умны, сэр, что я боюсь сделать опрометчивый вывод."
                }
        }
    }

    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
