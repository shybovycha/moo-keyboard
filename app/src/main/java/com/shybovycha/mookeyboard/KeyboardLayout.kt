package com.shybovycha.mookeyboard

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.GridLayout
import androidx.core.view.GestureDetectorCompat
import kotlin.math.abs

class KeyboardLayout @JvmOverloads constructor(
    private val onKeyPressHandler: ((String) -> Unit),
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : GridLayout(context, attrs, defStyleAttr) {

    private var motionEventInitiator: SquareButton? = null

    private val gestureDetector = GestureDetectorCompat(context, object : GestureDetector.SimpleOnGestureListener() {
        override fun onFling(e1: MotionEvent?, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
            Log.d("MooKeyboard", "e1: $e1, e2: $e2")

            if (e1 == null) return false

            val dx = e2.x - e1.x
            val dy = e2.y - e1.y

            when {
                abs(dx) > abs(dy) -> {
                    if (dx > 0) onSwipeListener(SquareButton.Direction.RIGHT)
                    else onSwipeListener(SquareButton.Direction.LEFT)
                }

                else -> {
                    if (dy > 0) onSwipeListener(SquareButton.Direction.DOWN)
                    else onSwipeListener(SquareButton.Direction.UP)
                }
            }

            resetMotionEvent()

            return true
        }

        override fun onSingleTapUp(e: MotionEvent): Boolean {
            Log.d("MooKeyboard", "single tap")

            onTapListener()

            resetMotionEvent()

            return true
        }

        override fun onDown(e: MotionEvent): Boolean {
            resetMotionEvent()

            return true
        }
    })

    init {
        columnCount = 4
        rowCount = 5
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

        val button = SquareButton(this::onTouchEventHandler, context)

        button.setBackgroundResource(R.drawable.key_preview_background)

        addView(
            button,
            LayoutParams(spec(rowIdx + 1, CENTER), spec(columnIdx, CENTER))
        )

        return button
    }

    private fun onSwipeListener(dir: SquareButton.Direction) {
        val key = motionEventInitiator?.getSubKey(dir)

        Log.d("MooKeyboard", "swipe $dir key $key")

        handleKey(key)
    }

    private fun onTapListener() {
        val key = motionEventInitiator?.getSubKey(SquareButton.Direction.CENTER)

        Log.d("MooKeyboard", "tap $key")

        handleKey(key)
    }

    private fun handleKey(key: String?) {
        if (key == null) return

        onKeyPressHandler.invoke(key)
    }

    private fun onTouchEventHandler(event: MotionEvent, initiator: SquareButton) {
        if (motionEventInitiator == null) {
            motionEventInitiator = initiator
        }

        gestureDetector.onTouchEvent(event)
    }

    private fun resetMotionEvent() {
        motionEventInitiator = null
    }
}
