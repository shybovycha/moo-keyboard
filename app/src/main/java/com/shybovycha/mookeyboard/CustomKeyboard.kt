package com.shybovycha.mookeyboard

import android.inputmethodservice.InputMethodService
import android.util.Log
import android.view.KeyEvent
import android.view.View

class CustomKeyboard : InputMethodService() {

    private lateinit var keyboardLayout: KeyboardLayout

    override fun onCreateInputView(): View {
        keyboardLayout = KeyboardLayout(this)

        val onKeyPressHandler: (String) -> Unit = fun (key: String) {
            onKeyPress(key)
        }

        val onBackspaceHandler: (String) -> Unit = fun (_) {
            Log.d("MooKeyboard", "backspace?")
            onBackspace()
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "A", onKeyPressHandler)
            addSubKey(1, 2, "-", onKeyPressHandler)
            addSubKey(2, 0, "$", onKeyPressHandler)
            addSubKey(2, 2, "V", onKeyPressHandler)
        }

        keyboardLayout.addKey().apply {
            addSubKey(0, 0, "`", onKeyPressHandler)
            addSubKey(0, 1, "^", onKeyPressHandler)
            addSubKey(0, 2, "´", onKeyPressHandler)
            addSubKey(1, 0, "+", onKeyPressHandler)
            addSubKey(1, 1, "N", onKeyPressHandler)
            addSubKey(1, 2, "!", onKeyPressHandler)
            addSubKey(2, 0, "/", onKeyPressHandler)
            addSubKey(2, 1, "L", onKeyPressHandler)
            addSubKey(2, 2, "\\", onKeyPressHandler)
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "I", onKeyPressHandler)
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "settings", fun (_) {})
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "H", onKeyPressHandler)
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "O", onKeyPressHandler)
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "R", onKeyPressHandler)
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "123", fun (_) {})
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "T", onKeyPressHandler)
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "E", onKeyPressHandler)
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "S", onKeyPressHandler)
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "⌫", onBackspaceHandler)
        }

        return keyboardLayout
    }

    private fun onKeyPress(key: String) {
        val inputConnection = currentInputConnection
        inputConnection?.commitText(key, 1)
    }

    private fun onBackspace() {
        val inputConnection = currentInputConnection
        inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL))
        inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DEL))
    }
}