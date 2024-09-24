package com.shybovycha.mookeyboard

import android.inputmethodservice.InputMethodService
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.GridLayout

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
            addSubKey(1, 1, "A", onKeyPressHandler).apply {
                setTextAppearance(R.style.MainKey)
            }
            addSubKey(1, 2, "-", onKeyPressHandler).apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(2, 0, "$", onKeyPressHandler).apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(2, 2, "V", onKeyPressHandler).apply {
                setTextAppearance(R.style.SubKey)
            }
        }

        keyboardLayout.addKey().apply {
            addSubKey(0, 0, "`", onKeyPressHandler).apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(0, 1, "^", onKeyPressHandler).apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(0, 2, "´", onKeyPressHandler).apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(1, 0, "+", onKeyPressHandler).apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(1, 1, "N", onKeyPressHandler).apply {
                setTextAppearance(R.style.MainKey)
            }
            addSubKey(1, 2, "!", onKeyPressHandler).apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(2, 0, "/", onKeyPressHandler).apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(2, 1, "L", onKeyPressHandler).apply {
                setTextAppearance(R.style.SubKey)
            }
            addSubKey(2, 2, "\\", onKeyPressHandler).apply {
                setTextAppearance(R.style.SymbolKey)
            }
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 0, "?", onKeyPressHandler).apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(1, 1, "I", onKeyPressHandler).apply {
                setTextAppearance(R.style.MainKey)
            }
            addSubKey(2, 0, "X", onKeyPressHandler).apply {
                setTextAppearance(R.style.SubKey)
            }
            addSubKey(2, 1, "=", onKeyPressHandler).apply {
                setTextAppearance(R.style.SymbolKey)
            }
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "⚙", fun (_) {}).apply {
                setTextAppearance(R.style.ControlKey)
            }
        }

        keyboardLayout.addKey().apply {
            addSubKey(0, 1, "{", onKeyPressHandler).apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(0, 2, "%", onKeyPressHandler).apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(1, 0, "(", onKeyPressHandler).apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(1, 1, "H", onKeyPressHandler).apply {
                setTextAppearance(R.style.MainKey)
            }
            addSubKey(1, 2, "K", onKeyPressHandler).apply {
                setTextAppearance(R.style.SubKey)
            }
            addSubKey(2, 0, "[", onKeyPressHandler).apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(2, 2, "_", onKeyPressHandler).apply {
                setTextAppearance(R.style.SymbolKey)
            }
        }

        keyboardLayout.addKey().apply {
            addSubKey(0, 0, "Q", onKeyPressHandler).apply {
                setTextAppearance(R.style.SubKey)
            }
            addSubKey(0, 1, "U", onKeyPressHandler).apply {
                setTextAppearance(R.style.SubKey)
            }
            addSubKey(0, 2, "P", onKeyPressHandler).apply {
                setTextAppearance(R.style.SubKey)
            }
            addSubKey(1, 0, "C", onKeyPressHandler).apply {
                setTextAppearance(R.style.SubKey)
            }
            addSubKey(1, 1, "O", onKeyPressHandler).apply {
                setTextAppearance(R.style.MainKey)
            }
            addSubKey(1, 2, "B", onKeyPressHandler).apply {
                setTextAppearance(R.style.SubKey)
            }
            addSubKey(2, 0, "G", onKeyPressHandler).apply {
                setTextAppearance(R.style.SubKey)
            }
            addSubKey(2, 1, "D", onKeyPressHandler).apply {
                setTextAppearance(R.style.SubKey)
            }
            addSubKey(2, 2, "J", onKeyPressHandler).apply {
                setTextAppearance(R.style.SubKey)
            }
        }

        keyboardLayout.addKey().apply {
            addSubKey(0, 0, "|", onKeyPressHandler).apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(0, 1, "↥", onKeyPressHandler).apply {
                setTextAppearance(R.style.ControlKey)
            }
            addSubKey(0, 2, "}", onKeyPressHandler).apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(1, 0, "M", onKeyPressHandler).apply {
                setTextAppearance(R.style.SubKey)
            }
            addSubKey(1, 1, "R", onKeyPressHandler).apply {
                setTextAppearance(R.style.MainKey)
            }
            addSubKey(1, 2, ")", onKeyPressHandler).apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(2, 0, "@", onKeyPressHandler).apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(2, 1, "↧", onKeyPressHandler).apply {
                setTextAppearance(R.style.ControlKey)
            }
            addSubKey(2, 2, "]", onKeyPressHandler).apply {
                setTextAppearance(R.style.SymbolKey)
            }
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "123", fun (_) {}).apply {
                setTextAppearance(R.style.ControlKey)
            }
        }

        keyboardLayout.addKey().apply {
            addSubKey(0, 0, "~", onKeyPressHandler).apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(0, 1, "¨", onKeyPressHandler).apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(0, 2, "Y", onKeyPressHandler).apply {
                setTextAppearance(R.style.SubKey)
            }
            addSubKey(1, 0, "<", onKeyPressHandler).apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(1, 1, "T", onKeyPressHandler).apply {
                setTextAppearance(R.style.MainKey)
            }
            addSubKey(1, 2, "*", onKeyPressHandler).apply {
                setTextAppearance(R.style.SymbolKey)
            }
        }

        keyboardLayout.addKey().apply {
            addSubKey(0, 0, "\"", onKeyPressHandler).apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(0, 1, "W", onKeyPressHandler).apply {
                setTextAppearance(R.style.SubKey)
            }
            addSubKey(0, 2, "'", onKeyPressHandler).apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(1, 1, "E", onKeyPressHandler).apply {
                setTextAppearance(R.style.MainKey)
            }
            addSubKey(1, 2, "Z", onKeyPressHandler).apply {
                setTextAppearance(R.style.SubKey)
            }
        }

        keyboardLayout.addKey().apply {
            addSubKey(0, 0, "F", onKeyPressHandler).apply {
                setTextAppearance(R.style.SubKey)
            }
            addSubKey(0, 1, "&", onKeyPressHandler).apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(1, 1, "S", onKeyPressHandler).apply {
                setTextAppearance(R.style.MainKey)
            }
            addSubKey(1, 2, ">", onKeyPressHandler).apply {
                setTextAppearance(R.style.SymbolKey)
            }
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "⌫", onBackspaceHandler).apply {
                setTextAppearance(R.style.ControlKey)
            }
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "␣", fun (_) { onKeyPress(" ") }).apply {
                setTextAppearance(R.style.ControlKey)
            }

            (layoutParams as GridLayout.LayoutParams).apply {
                columnSpec = GridLayout.spec(0, 3, 3f)
                rowSpec = GridLayout.spec(4)
            }
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "⏎", fun (_) { onKeyPressHandler("\n") }).apply {
                setTextAppearance(R.style.ControlKey)
            }

            (layoutParams as GridLayout.LayoutParams).apply {
                columnSpec = GridLayout.spec(3)
                rowSpec = GridLayout.spec(4)
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
        inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL))
        inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DEL))
    }
}