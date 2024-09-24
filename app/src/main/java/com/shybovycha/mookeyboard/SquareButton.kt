package com.shybovycha.mookeyboard;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.GridLayout
import android.widget.TextView
import androidx.core.view.GestureDetectorCompat
import kotlin.math.abs

class SquareButton(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : GridLayout(context, attrs, defStyleAttr) {

    enum class Direction {
        UP, DOWN, LEFT, RIGHT, UP_LEFT, UP_RIGHT, DOWN_LEFT, DOWN_RIGHT, CENTER
    }

    private val cells = Array(3) { Array(3) { TextView(context) } }

    private var onKeyPress: ((String) -> Unit)? = null

    private val subKeys = HashMap<Direction, String>()

    private val gestureDetector = GestureDetectorCompat(context, object : GestureDetector.SimpleOnGestureListener() {
        override fun onFling(e1: MotionEvent?, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
            Log.d("MooKeyboard", "e1: $e1, e2: $e2")

            if (e1 == null) return false

            val dx = e2.x - e1.x
            val dy = e2.y - e1.y

            when {
                abs(dx) > abs(dy) -> {
                    if (dx > 0) onSwipeListener(Direction.RIGHT)
                    else onSwipeListener(Direction.LEFT)
                }

                else -> {
                    if (dy > 0) onSwipeListener(Direction.DOWN)
                    else onSwipeListener(Direction.UP)
                }
            }

            return true
        }

        override fun onSingleTapUp(e: MotionEvent): Boolean {
            Log.d("MooKeyboard", "single tap")
            onCenterClickListener()
            return true
        }

        override fun onDown(e: MotionEvent): Boolean {
            return true
        }
    })

    init {
        columnCount = 3
        rowCount = 3
        setupGrid()
    }

    private fun setupGrid() {
        for (i in 0..2) {
            for (t in 0..2) {
                val cell = cells[i][t]
                cell.textAlignment = TEXT_ALIGNMENT_CENTER
//                cell.setBackgroundResource(R.drawable.key_preview_background)
                val params = LayoutParams(spec(i, 1f), spec(t, 1f))
                params.setGravity(TEXT_ALIGNMENT_CENTER)
                addView(cell, params)
            }
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val size = measuredWidth.coerceAtMost(measuredHeight)
        setMeasuredDimension(size, size)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        Log.d("MooKeyboard", "touch event: $event")
        return gestureDetector.onTouchEvent(event) || super.onTouchEvent(event)
    }

    fun addSubKey(row: Int, column: Int, key: String, onKeyPressHandler: (key: String) -> Unit) {
        cells[row][column].text = key

        onKeyPress = onKeyPressHandler

        subKeys[getDirection(row, column)] = key
    }

    private fun getDirection(row: Int, column: Int): Direction {
        return when {
            row == 0 && column == 0 -> Direction.UP_LEFT
            row == 0 && column == 1 -> Direction.UP
            row == 0 && column == 2 -> Direction.UP_RIGHT
            row == 1 && column == 0 -> Direction.LEFT
            row == 1 && column == 1 -> Direction.CENTER
            row == 1 && column == 2 -> Direction.RIGHT
            row == 2 && column == 0 -> Direction.DOWN_LEFT
            row == 2 && column == 1 -> Direction.DOWN
            else -> Direction.DOWN_RIGHT
        }
    }

    private fun onSwipeListener(dir: Direction) {
        Log.d("MooKeyboard", "swipe $dir")
        if (subKeys.containsKey(dir)) onKeyPress?.invoke(subKeys[dir] as String)
    }

    private fun onCenterClickListener() {
//        Log.d("MooKeyboard", "center tap")
        if (subKeys.containsKey(Direction.CENTER)) onKeyPress?.invoke(subKeys[Direction.CENTER] as String)
    }
}
