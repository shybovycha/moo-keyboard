package com.shybovycha.mookeyboard;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridLayout
import android.widget.TextView

class SquareButton(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : GridLayout(context, attrs, defStyleAttr) {

    init {
        columnCount = 3
        rowCount = 3
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val size = measuredWidth.coerceAtMost(measuredHeight)
        setMeasuredDimension(size, size)
    }

    fun addSubKey(row: Int, column: Int, key: String) {// onClickListener: OnClickListener) {
        val button = TextView(context).apply {
            text = key
//            setOnClickListener(onClickListener)
        }

        addView(button, LayoutParams(spec(row, CENTER), spec(column, CENTER)))
    }
}
