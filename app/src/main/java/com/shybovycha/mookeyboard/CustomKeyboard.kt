package com.shybovycha.mookeyboard

import android.inputmethodservice.InputMethodService
import android.view.View

class CustomKeyboard : InputMethodService() {

    private lateinit var keyboardLayout: KeyboardLayout

    override fun onCreateInputView(): View {
        keyboardLayout = KeyboardLayout(this)

        val keys = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "⌫")

        for (key in keys) {
            keyboardLayout.addKey(key) {
                when (key) {
                    "⌫" -> onBackspace()
                    else -> onKeyPress(key)
                }
            }
        }

        return keyboardLayout
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