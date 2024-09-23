package com.shybovycha.mookeyboard

import android.inputmethodservice.InputMethodService
import android.view.View

class CustomKeyboard : InputMethodService() {

    private lateinit var keyboardLayout: KeyboardLayout

    override fun onCreateInputView(): View {
        keyboardLayout = KeyboardLayout(this)

//        val keys = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "⌫")
//
//        for (key in keys) {
//            keyboardLayout.addKey(key) {
//                when (key) {
//                    "⌫" -> onBackspace()
//                    else -> onKeyPress(key)
//                }
//            }
//        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "A") //, fun(key: String) { onKeyPress("A") })
            addSubKey(1, 2, "-")
            addSubKey(2, 0, "$")
            addSubKey(2, 2, "V")
        }

        keyboardLayout.addKey().apply {
            addSubKey(0, 0, "`")
            addSubKey(0, 1, "^")
            addSubKey(0, 2, "´")
            addSubKey(1, 0, "+")
            addSubKey(1, 1, "N")
            addSubKey(1, 2, "!")
            addSubKey(2, 0, "/")
            addSubKey(2, 1, "L")
            addSubKey(2, 2, "\\")
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "I")
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "settings")
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "H")
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "O")
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "R")
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "123")
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "T")
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "E")
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "S")
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "⌫")
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