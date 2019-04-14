package com.mmcs.iqmeter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
//import android.text.TextUtils
import android.view.View
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        startButton.setOnClickListener{
            if (inputField.text.isEmpty()) {
                resultTextView.text = getString(R.string.no_text) //Если поле ввода пусто - предупреждаем пользователя
            } else {
                resultTextView.text = answerFunction(inputField.text.toString().toInt(),
                    if (this.checkBoxOne.isChecked) this.checkBoxOne else this.checkBoxSecond)
            }
        }

        checkBoxOne.setOnClickListener(this) //Устанавливаем слушателя не в разметке, а из кода
        checkBoxSecond.setOnClickListener(this)
    }

    fun answerFunction(iqValue: Int, checkBox: CheckBox): String {
        if (checkBox.id == R.id.checkBoxOne) {
            when (iqValue) {
                in 1..10 -> return "А ведь это - результат! Вы значительно умнее рыбки."
                in 11..25 -> return "Вы настолько умны, что можете разговаривать с животными."
                in 26..80 -> return "Вы умнее домашнего кота и он отказывается с Вами это обсуждать."
                else -> return "Вы настолько умны, сэр, что я боюсь сделать опрометчивый вывод."
            }
        } else {
            when (iqValue) {
                in 1..10 -> return "Да уж, $iqValue... Вам есть куда развиваться. Вы слегка умнее рыбки."
                in 11..25 -> return "Где-то на уровне домашнего кота. Теперь Вы можете разговаривать с ним на равных."
                in 26..80 -> return "Поздравляю! Вы умнее наглого домашнего кота. Правда ему плевать на это."
                else -> return "Вы настолько умны, сэр, что я боюсь сделать опрометчивый вывод."
            }
        }
    }

    override fun onClick(v: View?) {
        v as CheckBox //кастинг View
        var isChecked: Boolean = v.isChecked

        if (inputField.text.isNotEmpty()) {
            var iqValue = inputField.text
            when (v.id) {
                R.id.checkBoxOne -> if (isChecked) {
                    resultTextView.text = answerFunction(iqValue.toString().toInt(), v) //Передаем в функцию введенные данные и CheckBox
                    checkBoxSecond.isChecked = false //Если выбран первый checkBox, то второй должен быть не активен
                }
                R.id.checkBoxSecond -> if (isChecked) {
                    resultTextView.text = answerFunction(iqValue.toString().toInt(), v)
                    checkBoxOne.isChecked = false
                }
            }
        } else {
            resultTextView.text = getString(R.string.no_text)
            checkBoxOne.isChecked = true
            checkBoxOne.isChecked = false
        }
    }
}