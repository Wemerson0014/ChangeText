package com.estudo.changetext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textChanged.text = if (savedInstanceState == null) {
            getString(R.string.app_name)
        } else {
            savedInstanceState.getString("myText")
        }

        // Método similar de resoluação para condição de saveInstanceState
        //textChanged.text = savedInstanceState?.getString("myText") ?: "NULL"

        // Outra forma
//        savedInstanceState?.let {
//            val myText = it.getString("myText")
//            textChanged.text = myText
//        }

        buttonChangeText.setOnClickListener(View.OnClickListener {
            val textWritten = editYourText.text.toString()
            editYourText.setText("")
            textChanged.text = textWritten
        })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val myText = textChanged.text.toString()
        outState.putString("myText", myText)
    }
}