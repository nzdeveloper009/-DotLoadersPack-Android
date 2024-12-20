package com.nokhaiz.dotsloader.loaders

import android.content.Context
import android.util.AttributeSet
import android.view.ViewTreeObserver
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.LinearLayout
import com.nokhaiz.dotsloader.basicviews.CircleView
import com.nokhaiz.dotsloader.contracts.LoaderContract
import com.nokhaiz.dotsloader.R
import com.nokhaiz.dotsloader.utils.random
import java.util.ArrayList

class LightsLoader : LinearLayout, LoaderContract {

    var noOfCircles: Int = 3
        set(value) {
            field = if (value < 1) 1 else value
        }

    var circleRadius: Int = 30
    var circleDistance: Int = 10

    var circleColor: Int = resources.getColor(android.R.color.holo_purple)

    private var calWidthHeight: Int = 0

    private lateinit var circlesList: ArrayList<CircleView>


    constructor(context: Context) : super(context) {
        initView()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initAttributes(attrs)
        initView()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initAttributes(attrs)
        initView()
    }

    constructor(context: Context, noOfCircles: Int, circleRadius: Int, circleDistance: Int, circleColor: Int) : super(context) {
        this.noOfCircles = noOfCircles
        this.circleRadius = circleRadius
        this.circleDistance = circleDistance
        this.circleColor = circleColor

        initView()
    }

    override fun initAttributes(attrs: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.LightsLoader, 0, 0)

        noOfCircles = typedArray.getInteger(R.styleable.LightsLoader_lights_noOfCircles, 3)

        circleRadius = typedArray.getDimensionPixelSize(R.styleable.LightsLoader_lights_circleRadius, 30)
        circleDistance = typedArray.getDimensionPixelSize(R.styleable.LightsLoader_lights_circleDistance, 10)

        circleColor = typedArray.getColor(
            R.styleable.LightsLoader_lights_circleColor,
                resources.getColor(android.R.color.holo_purple))

        typedArray.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        if (calWidthHeight == 0) {
            calWidthHeight = (2 * circleRadius * noOfCircles) + ((noOfCircles - 1) * circleDistance)
        }

        setMeasuredDimension(calWidthHeight, calWidthHeight)
    }


    private fun initView() {
        removeAllViews()
        removeAllViewsInLayout()

        orientation = LinearLayout.VERTICAL

        circlesList = ArrayList()

        if (calWidthHeight == 0) {
            calWidthHeight = (2 * circleRadius * noOfCircles) + ((noOfCircles - 1) * circleDistance)
        }

        for (countI in 0 until noOfCircles) {
            val linearLayout = LinearLayout(context)
            linearLayout.orientation = LinearLayout.HORIZONTAL
            val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)

            if (countI != 0) {
                params.topMargin = circleDistance
            }

            linearLayout.layoutParams = params

            for (countJ in 0 until noOfCircles) {
                val circleView = CircleView(context, circleRadius, circleColor)

                val innerParam = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)

                if (countJ != 0) {
                    innerParam.leftMargin = circleDistance
                }

                linearLayout.addView(circleView, innerParam)
                circlesList.add(circleView)
            }

            addView(linearLayout)
        }

        viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                startLoading()
                this@LightsLoader.viewTreeObserver.removeOnGlobalLayoutListener(this)
            }
        })
    }

    private fun startLoading() {
        for (count in 0 until noOfCircles) {
            for (item in circlesList) {
                item.startAnimation(getAlphaAnimation())
            }
        }
    }

    private fun getAlphaAnimation(): Animation {
        val fromAplha = (0.5f..1.0f).random()
        val toAplha = (0.1f..0.5f).random()

        val alphaAnim = AlphaAnimation(fromAplha, toAplha)
                .apply {
                    duration = (100..1000).random().toLong()
                    repeatMode = Animation.REVERSE
                    repeatCount = Animation.INFINITE
                }

        return alphaAnim
    }
}

