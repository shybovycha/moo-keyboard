package com.shybovycha.mookeyboard;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.GridLayout
import android.widget.TextView

class SquareButton(
    private val onTouchEventHandler: ((MotionEvent, SquareButton) -> Unit),
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : GridLayout(context, attrs, defStyleAttr) {

    enum class Direction {
        UP, DOWN, LEFT, RIGHT, UP_LEFT, UP_RIGHT, DOWN_LEFT, DOWN_RIGHT, CENTER
    }

    private val cells: Array<Array<View>> = Array(3) { Array(3) { TextView(context) } }

    private val subKeys = HashMap<Direction, String>()

    init {
        columnCount = 3
        rowCount = 3
        setupGrid()
    }

    private fun setupGrid() {
        for (i in 0..2) {
            for (t in 0..2) {
                val cell = cells[i][t] as TextView
                cell.textAlignment = TEXT_ALIGNMENT_CENTER
                cell.text = " "
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
        onTouchEventHandler.invoke(event, this)
        return true
    }

    fun addSubKey(row: Int, column: Int, key: String): TextView {
        val view = TextView(context).apply {
            text = key
            textAlignment = TEXT_ALIGNMENT_CENTER
        }

        return addSubKey(row, column, key, view)
    }

    fun <T : View>addSubKey(row: Int, column: Int, key: String, view: T): T {
        removeView(cells[row][column])

        val params = LayoutParams(spec(row, 1f), spec(column, 1f))
        params.setGravity(TEXT_ALIGNMENT_CENTER)
        addView(view, params)

        cells[row][column] = view

        subKeys[getDirection(row, column)] = key

        return cells[row][column] as T
    }

    fun getSubKey(dir: Direction): String? {
        if (!subKeys.containsKey(dir)) return null

        return subKeys[dir]
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
}
