package com.example.odevfinal

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SeekBar

class fragacilis : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var fragacilis=inflater.inflate(R.layout.fragment_fragacilis,container,false)
        var ucgen = fragacilis.findViewById<ImageView>(R.id.ucgen)


        var durdev = 1
        object : CountDownTimer(5000,500) {
            override fun onTick(p0: Long) {
                if(durdev == 1){
                    ucgen.visibility = View.VISIBLE
                    durdev = 2
                }else {
                    ucgen.visibility=View.INVISIBLE
                    durdev = 1
                }

            }
            override fun onFinish() {
            }

        }.start()





        return fragacilis
    }

}
