package com.mmcs.iqmeter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        startButton.setOnClickListener{
            if (inputField.text.isEmpty()) resultTextView.text = "@string/no_text" //Если поле ввода пусто - предупреждаем пользователя
            var result = answerFunction(inputField.text.toString().toInt())
            resultTextView.text = result //Результат выводим в соответствующем поле
        }

        checkBoxOne.setOnClickListener(this) //Устанавливаем слушателя не в разметке, а из кода
        checkBoxSecond.setOnClickListener(this)
    }

    fun answerFunction(iqValue: Int): String {
        when (iqValue) {
            in 1..10 -> return "Да уж, $iqValue... Вам есть куда развиваться. Вы слегка умнее рыбки."
            in 11..25 -> return "Где-то на уровне домашнего кота. Теперь Вы можете разговаривать с ним на равных."
            in 26..80 -> return "Поздравляю! Вы умнее наглого домашнего кота. Правда ему плевать на это."
            else -> return "Вы настолько умны, сэр, что я боюсь сделать опрометчивый вывод."
        }
    }

    override fun onClick(v: View?) {
        v as CheckBox //кастинг View
        var isChecked: Boolean = v.isChecked

        when (v.id) {
            R.id.checkBoxOne -> if (isChecked) {
                Log.d("First checked", "First")
                checkBoxSecond.isChecked = false //Если выбран первый checkBox, то второй должен быть не активен
            }
            R.id.checkBoxSecond -> if (isChecked) {
                Log.d("Second checked", "Second")
                checkBoxOne.isChecked = false
            }
        }

    }
}
