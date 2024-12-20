package com.nokhaiz.dotsloader.basicviews

import android.content.Context
import android.util.AttributeSet
import com.nokhaiz.dotsloader.R
import com.nokhaiz.dotsloader.contracts.AbstractLinearLayout

/**
 * Created by suneet on 12/14/17.
 */
abstract class ThreeDotsBaseView : AbstractLinearLayout {

    var firstDotColor: Int = resources.getColor(R.color.loader_defalut)

    var secondDotColor: Int = resources.getColor(R.color.loader_defalut)

    var thirdDotColor: Int = resources.getColor(R.color.loader_defalut)

    protected lateinit var firstCircle: CircleView
    protected lateinit var secondCircle: CircleView
    protected lateinit var thirdCircle: CircleView

    constructor(context: Context, dotsRadius: Int, dotsDist: Int,
                firstDotColor: Int, secondDotColor: Int, thirdDotColor: Int) : super(context) {
        this.dotsRadius = dotsRadius
        this.dotsDist = dotsDist
        this.firstDotColor = firstDotColor
        this.secondDotColor = secondDotColor
        this.thirdDotColor = thirdDotColor
    }

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
}

