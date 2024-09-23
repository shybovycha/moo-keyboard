package com.shybovycha.mookeyboard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity
import android.widget.Button

class SquareButton(
    context:Context,
    attrs:AttributeSet? = null,
    defStyleAttr: Int = 0
) : Button(context, attrs, defStyleAttr) {

    init {
        gravity = Gravity.CENTER
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val size = measuredWidth.coerceAtMost(measuredHeight)
        setMeasuredDimension(size, size)
    }
}
