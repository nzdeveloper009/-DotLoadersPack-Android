package com.nokhaiz.dotsloader.basicviews

import android.content.Context
import android.util.AttributeSet
import com.nokhaiz.dotsloader.contracts.CircularAbstractView

class CircularLoaderBaseView : CircularAbstractView {

    constructor(context: Context) : super(context) {
        initCordinates()
        initPaints()
    }

    constructor(context: Context, dotsRadius: Int, bigCircleRadius: Int, dotsColor: Int) : super(context) {
        this.radius = dotsRadius
        this.bigCircleRadius = bigCircleRadius
        this.defaultColor = dotsColor

        initCordinates()
        initPaints()
    }

    constructor(context: Context, dotsRadius: Int, bigCircleRadius: Int, dotsColorsArray: IntArray) : super(context) {
        this.radius = dotsRadius
        this.bigCircleRadius = bigCircleRadius
        this.dotsColorsArray = dotsColorsArray
        this.useMultipleColors = true

        initCordinates()
        initPaints()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initAttributes(attrs)
        initCordinates()
        initPaints()
        initShadowPaints()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initAttributes(attrs)
        initCordinates()
        initPaints()
        initShadowPaints()
    }

}