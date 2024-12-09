package com.nokhaiz.loaders

import android.os.Bundle
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.nokhaiz.dotsloader.loaders.*

class MainActivity : AppCompatActivity() {

    lateinit var containerLL: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_lineardotsloader)

        supportActionBar?.title = "BounceLoader"

        containerLL = findViewById(R.id.container) as LinearLayout

        //initLinearDotsLoader()
        //initCircularDotsLoader()

        //initLazyLoader()
        //initTashieLoader()

        //initSlidongLoader()
        //initRotatingCircularDotsLoader()

        //initTrailingCirculerDotsLoader()
        //initZeeLoader()

        //initAllianceLoader()
        //initLightsLoader()

        //initPullInLoader()
        //initBounceLoader()
    }

    private fun initBounceLoader() {
        val bounceLoader = BounceLoader(context = this,
            ballRadius = 60,
            ballColor = ContextCompat.getColor(this, R.color.red),
            showShadow = true,
            shadowColor = ContextCompat.getColor(this, R.color.black))
            .apply {
                animDuration = 1000
            }

        containerLL.addView(bounceLoader)
    }

    private fun initPullInLoader() {
        val pullInLoader = PullInLoader(this,
            20, 100, ContextCompat.getColor(this, R.color.red))
            .apply {
                animDuration = 2000
            }

        containerLL.addView(pullInLoader)

        val pullInLoader2 = PullInLoader(this,
            30, 160, resources.getIntArray(R.array.vibgyorg))
            .apply {
                animDuration = 2000
            }

        containerLL.addView(pullInLoader2)
    }

    private fun initLightsLoader() {
        val lightsLoader = LightsLoader(
            this, 5,
            30, 10,
            ContextCompat.getColor(this, R.color.red))


        containerLL.addView(lightsLoader)
    }

    private fun initAllianceLoader() {
        val allianceLoader = AllianceLoader(
            this,
            40,
            6,
            true,
            10,
            ContextCompat.getColor(this, R.color.red),
            ContextCompat.getColor(this, R.color.amber),
            ContextCompat.getColor(this, R.color.green)
        ).apply {
            animDuration = 5000
        }

        containerLL.addView(allianceLoader)
    }

    private fun initZeeLoader() {
        val zeeLoader = ZeeLoader(
            this,
            60,
            4,
            ContextCompat.getColor(this, R.color.red),
            ContextCompat.getColor(this, R.color.red))
            .apply {
                animDuration = 200
            }

        containerLL.addView(zeeLoader)
    }

    private fun initTrailingCirculerDotsLoader() {
        var trailingCircularDotsLoader = TrailingCircularDotsLoader(
            this,
            24,
            ContextCompat.getColor(this, android.R.color.holo_green_light),
            100,
            5)
            .apply {
                animDuration = 1200
                animDelay = 200
            }

        containerLL.addView(trailingCircularDotsLoader)
    }


    private fun initRotatingCircularDotsLoader() {
        val loader = RotatingCircularDotsLoader(this,
            20, 60, ContextCompat.getColor(this, R.color.red))
            .apply {
                animDuration = 10000
            }

        containerLL.addView(loader)
    }

    private fun initSlidongLoader() {
        var sliding = SlidingLoader(this, 20, 5,
            ContextCompat.getColor(this, R.color.red),
            ContextCompat.getColor(this, R.color.yellow),
            ContextCompat.getColor(this, R.color.green)).apply {
            animDuration = 1500
            distanceToMove = 12
        }

        containerLL.addView(sliding)
    }

    private fun initTashieLoader() {
        var tashie = TashieLoader(
            this, 5,
            30, 10,
            ContextCompat.getColor(this, R.color.green))
            .apply {
                animDuration = 500
                animDelay = 100
                interpolator = LinearInterpolator()
            }
        containerLL.addView(tashie)
    }

    private fun initLazyLoader() {
        var lazyLoader = LazyLoader(this, 15, 5,
            ContextCompat.getColor(this, R.color.loader_selected),
            ContextCompat.getColor(this, R.color.loader_selected),
            ContextCompat.getColor(this, R.color.loader_selected))
            .apply {
                animDuration = 500
                firstDelayDuration = 100
                secondDelayDuration = 200
                interpolator = DecelerateInterpolator()
            }

        /*var lazyLoader = LazyLoader(this).apply{
            animDuration = 500
            firstDelayDuration = 100
            secondDelayDuration = 200
        }
        lazyLoader.dotsRadius = 60
        lazyLoader.dotsDist = 60*/

        containerLL.addView(lazyLoader)
    }

    private fun initCircularDotsLoader() {
        var cirLoader = CircularDotsLoader(this@MainActivity)
        cirLoader.setPadding(20, 20, 20, 20)
        cirLoader.defaultColor = ContextCompat.getColor(this, R.color.blue_delfault)
        cirLoader.selectedColor = ContextCompat.getColor(this, R.color.blue_selected)
        cirLoader.bigCircleRadius = 116
        cirLoader.radius = 40
        cirLoader.animDur = 100
        cirLoader.firstShadowColor = ContextCompat.getColor(this, R.color.pink_selected)
        cirLoader.secondShadowColor = ContextCompat.getColor(this, R.color.purple_selected)
        cirLoader.showRunningShadow = true

        containerLL.addView(cirLoader)
    }

    private fun initLinearDotsLoader() {
        val loader = LinearDotsLoader(this)
        loader.defaultColor = ContextCompat.getColor(this, R.color.loader_defalut)
        loader.selectedColor = ContextCompat.getColor(this, R.color.loader_selected)
        loader.isSingleDir = false
        loader.noOfDots = 5
        loader.selRadius = 60
        loader.expandOnSelect = false
        loader.radius = 40
        loader.dotsDistance = 20
        loader.animDur = 1000
        //loader.firstShadowColor = ContextCompat.getColor(this, R.color.pink_selected)
        //loader.secondShadowColor = ContextCompat.getColor(this, R.color.purple_selected)
        //loader.showRunningShadow = false
        containerLL.addView(loader)


    }
}
