package com.shybovycha.mookeyboard

import android.inputmethodservice.InputMethodService
import android.view.View
import android.widget.Button
import android.widget.GridLayout

class CustomKeyboard : InputMethodService() {

    private lateinit var keyboardView: View
    private val buttons = mutableListOf<Button>()

    override fun onCreateInputView(): View {
        keyboardView = layoutInflater.inflate(R.layout.keyboard_layout3, null)

        val gridLayout = keyboardView.findViewById<GridLayout>(R.id.gridLayout)

        for (i in 1..9) {
            val button = Button(this)
            button.text = i.toString()
            button.setOnClickListener { onKeyPress(i.toString()) }
            buttons.add(button)
            gridLayout.addView(button)
        }

        val backspaceButton = Button(this)
        backspaceButton.text = "⌫"
        backspaceButton.setOnClickListener { onBackspace() }
        buttons.add(backspaceButton)
        gridLayout.addView(backspaceButton)

        return keyboardView
    }

    private fun onKeyPress(key: String) {
        val inputConnection = currentInputConnection
        inputConnection?.commitText(key, 1)
    }

    private fun onBackspace() {
        val inputConnection = currentInputConnection
        inputConnection?.deleteSurroundingText(1, 0)
    }
}