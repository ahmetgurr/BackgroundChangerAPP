package com.example.odevfinal

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView

class rgbf : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var rgbdeg =inflater.inflate(R.layout.fragment_rgbf,container,false)

        var redbar = rgbdeg.findViewById<SeekBar>(R.id.redbar)
        var green = rgbdeg.findViewById<SeekBar>(R.id.greenbar)
        var blue = rgbdeg.findViewById<SeekBar>(R.id.bluebar)

        var renkkodu= rgbdeg.findViewById<TextView>(R.id.renkkodu)

        var arkaplan =rgbdeg.findViewById<FrameLayout>(R.id.arkaplan)

        var r = 0
        var g = 0
        var b= 0
        var rr ="00"
        var gg ="00"
        var bb ="00"

        redbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                r = redbar.progress
                rr = Integer.toHexString(r)
                arkaplan.setBackgroundColor(Color.rgb(r,g,b))
                renkkodu.text = "#$rr$gg$bb"
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })
        green.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                g = green.progress
                gg = Integer.toHexString(g)
                arkaplan.setBackgroundColor(Color.rgb(r,g,b))
                renkkodu.text = "#$rr$gg$bb"
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })

        blue.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                b = blue.progress
                bb = Integer.toHexString(b)
                arkaplan.setBackgroundColor(Color.rgb(r,g,b))
                renkkodu.text = "#$rr$gg$bb"
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })


        return rgbdeg
    }
}
