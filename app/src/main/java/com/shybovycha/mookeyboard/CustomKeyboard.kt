package com.shybovycha.mookeyboard

import android.inputmethodservice.InputMethodService
import android.view.KeyEvent
import android.view.View
import android.widget.GridLayout
import android.widget.ImageView

class CustomKeyboard : InputMethodService() {

    private lateinit var keyboardLayout: KeyboardLayout

    override fun onCreateInputView(): View {
        keyboardLayout = KeyboardLayout(this::onKeyPress, this)

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "A").apply {
                setTextAppearance(R.style.MainKey)
            }
            addSubKey(1, 2, "-").apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(2, 0, "$").apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(2, 2, "V").apply {
                setTextAppearance(R.style.SubKey)
            }
        }

        keyboardLayout.addKey().apply {
            addSubKey(0, 0, "`").apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(0, 1, "^").apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(0, 2, "´").apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(1, 0, "+").apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(1, 1, "N").apply {
                setTextAppearance(R.style.MainKey)
            }
            addSubKey(1, 2, "!").apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(2, 0, "/").apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(2, 1, "L").apply {
                setTextAppearance(R.style.SubKey)
            }
            addSubKey(2, 2, "\\").apply {
                setTextAppearance(R.style.SymbolKey)
            }
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 0, "?").apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(1, 1, "I").apply {
                setTextAppearance(R.style.MainKey)
            }
            addSubKey(2, 0, "X").apply {
                setTextAppearance(R.style.SubKey)
            }
            addSubKey(2, 1, "=").apply {
                setTextAppearance(R.style.SymbolKey)
            }
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "settings", ImageView(context)).apply {
                setImageResource(R.drawable.baseline_settings_16)
            }
        }

        keyboardLayout.addKey().apply {
            addSubKey(0, 1, "{").apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(0, 2, "%").apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(1, 0, "(").apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(1, 1, "H").apply {
                setTextAppearance(R.style.MainKey)
            }
            addSubKey(1, 2, "K").apply {
                setTextAppearance(R.style.SubKey)
            }
            addSubKey(2, 0, "[").apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(2, 2, "_").apply {
                setTextAppearance(R.style.SymbolKey)
            }
        }

        keyboardLayout.addKey().apply {
            addSubKey(0, 0, "Q").apply {
                setTextAppearance(R.style.SubKey)
            }
            addSubKey(0, 1, "U").apply {
                setTextAppearance(R.style.SubKey)
            }
            addSubKey(0, 2, "P").apply {
                setTextAppearance(R.style.SubKey)
            }
            addSubKey(1, 0, "C").apply {
                setTextAppearance(R.style.SubKey)
            }
            addSubKey(1, 1, "O").apply {
                setTextAppearance(R.style.MainKey)
            }
            addSubKey(1, 2, "B").apply {
                setTextAppearance(R.style.SubKey)
            }
            addSubKey(2, 0, "G").apply {
                setTextAppearance(R.style.SubKey)
            }
            addSubKey(2, 1, "D").apply {
                setTextAppearance(R.style.SubKey)
            }
            addSubKey(2, 2, "J").apply {
                setTextAppearance(R.style.SubKey)
            }
        }

        keyboardLayout.addKey().apply {
            addSubKey(0, 0, "|").apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(0, 1, "↥").apply {
                setTextAppearance(R.style.ControlKey)
            }
            addSubKey(0, 2, "}").apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(1, 0, "M").apply {
                setTextAppearance(R.style.SubKey)
            }
            addSubKey(1, 1, "R").apply {
                setTextAppearance(R.style.MainKey)
            }
            addSubKey(1, 2, ")").apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(2, 0, "@").apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(2, 1, "↧").apply {
                setTextAppearance(R.style.ControlKey)
            }
            addSubKey(2, 2, "]").apply {
                setTextAppearance(R.style.SymbolKey)
            }
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "123").apply {
                setTextAppearance(R.style.ControlKey)
            }
        }

        keyboardLayout.addKey().apply {
            addSubKey(0, 0, "~").apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(0, 1, "¨").apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(0, 2, "Y").apply {
                setTextAppearance(R.style.SubKey)
            }
            addSubKey(1, 0, "<").apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(1, 1, "T").apply {
                setTextAppearance(R.style.MainKey)
            }
            addSubKey(1, 2, "*").apply {
                setTextAppearance(R.style.SymbolKey)
            }
        }

        keyboardLayout.addKey().apply {
            addSubKey(0, 0, "\"").apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(0, 1, "W").apply {
                setTextAppearance(R.style.SubKey)
            }
            addSubKey(0, 2, "'").apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(1, 1, "E").apply {
                setTextAppearance(R.style.MainKey)
            }
            addSubKey(1, 2, "Z").apply {
                setTextAppearance(R.style.SubKey)
            }
        }

        keyboardLayout.addKey().apply {
            addSubKey(0, 0, "F").apply {
                setTextAppearance(R.style.SubKey)
            }
            addSubKey(0, 1, "&").apply {
                setTextAppearance(R.style.SymbolKey)
            }
            addSubKey(1, 1, "S").apply {
                setTextAppearance(R.style.MainKey)
            }
            addSubKey(1, 2, ">").apply {
                setTextAppearance(R.style.SymbolKey)
            }
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "backspace", ImageView(context)).apply {
                setImageResource(R.drawable.baseline_backspace_16)
            }
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "space", ImageView(context)).apply {
                setImageResource(R.drawable.baseline_space_bar_16)
            }

            (layoutParams as GridLayout.LayoutParams).apply {
                columnSpec = GridLayout.spec(0, 3, 3f)
                rowSpec = GridLayout.spec(4)
            }
        }

        keyboardLayout.addKey().apply {
            addSubKey(1, 1, "enter", ImageView(context)).apply {
                setImageResource(R.drawable.baseline_keyboard_return_16)
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

        when (key) {
            "backspace" -> {
                inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL))
                inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DEL))
            }
            "enter" -> {
                inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER))
                inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_ENTER))
            }
            "space" -> {
                inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_SPACE))
                inputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_SPACE))
            }
            else -> {
                inputConnection?.commitText(key, 1)
            }
        }
    }
}