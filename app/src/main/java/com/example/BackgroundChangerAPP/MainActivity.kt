package com.example.odevfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.SeekBar
import androidx.lifecycle.VIEW_MODEL_STORE_OWNER_KEY

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var seek = findViewById<SeekBar>(R.id.kaydir)
        var prgrsbr =findViewById<ProgressBar>(R.id.progressBar)

        seek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if (seek.progress == 12) {
                    prgrsbr.visibility = View.VISIBLE
                    object : CountDownTimer(3000,50) {
                        var a = 12
                        override fun onTick(p0: Long) {
                            if(a>0){
                                seek.progress = a
                                a = a-1
                            }else{
                                seek.progress = 0
                            }

                        }
                        override fun onFinish() {
                            var gecis = Intent(this@MainActivity,Anaekran::class.java )
                            startActivity(gecis)
                            finish()
                        }

                    }.start()
                }
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {
                if (seek.progress != 12) {
                    object : CountDownTimer(3000,50) {
                        var q = seek.progress
                        override fun onTick(p0: Long) {
                            if(q>0){
                                seek.progress = q
                                q = q-1
                            }else{
                                seek.progress = 0
                            }
                        }
                        override fun onFinish() {
                        }
                    }.start()

                }
            }

        })
    }
}


