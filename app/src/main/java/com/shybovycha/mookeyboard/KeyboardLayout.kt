package com.shybovycha.mookeyboard

import android.content.Context
import android.util.AttributeSet
import android.widget.GridLayout

class KeyboardLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : GridLayout(context, attrs, defStyleAttr) {

    init {
        columnCount = 4
        rowCount = 4
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val size = measuredWidth / 4
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            val lp = child.layoutParams as LayoutParams
            lp.width = size
            lp.height = size
            child.layoutParams = lp
        }
    }

    fun addKey(): SquareButton {
        val rowIdx = childCount / columnCount
        val columnIdx = childCount % columnCount

        val button = SquareButton(context)

        button.setBackgroundResource(R.drawable.key_preview_background)

        addView(button, LayoutParams(spec(rowIdx + 1, CENTER), spec(columnIdx, CENTER)))

        return button
    }
}
