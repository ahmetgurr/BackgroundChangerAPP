package com.example.odevfinal

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.PopupMenu
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment



class fragmentekran : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragmentekran)


        var buton = findViewById<Button>(R.id.button)

        var r = 0
        var g = 0
        var b= 0
        var rr ="00"
        var gg ="00"
        var bb ="00"

        var preferences = getSharedPreferences(dosyayolu, Context.MODE_PRIVATE)
        var editor = preferences.edit()

        /*var anahtaryas = intent.getStringExtra("anahtaryas")
        var anahtarisim = intent.getStringExtra("anahtarisim")
        var unutma = intent.getStringExtra("unutma")*/

        fun fragmentcagir(bolum: Fragment){
            var gecis =supportFragmentManager.beginTransaction()
            gecis.replace(R.id.fragmentContainerView12,bolum)
            gecis.commit()
        }

        buton.setOnClickListener {
            val acilirmenu = PopupMenu(this@fragmentekran,buton)
            acilirmenu.menuInflater.inflate(R.menu.popupmenu,acilirmenu.menu)


            acilirmenu.setOnMenuItemClickListener { i->

                when(i.itemId){
                    R.id.RGB -> {
                        fragmentcagir(rgbf())
                        true }

                    R.id.Snackbar -> {
                        fragmentcagir(snackf())
                        true }

                    R.id.Cikis -> {
                        val tasarim = layoutInflater.inflate(R.layout.uyari, null)
                        val ozeluyaripenceresi = AlertDialog.Builder(this@fragmentekran)
                        ozeluyaripenceresi.setView(tasarim)
                        var isim = tasarim.findViewById<EditText>(R.id.name)
                        var sifre = tasarim.findViewById<EditText>(R.id.sifre)


                        isim.addTextChangedListener(object : TextWatcher {
                            override fun afterTextChanged(p0: Editable?) {
                            }
                            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                            }
                            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                                var isimm = isim.text.toString()
                                var yass = sifre.text.toString()
                                if(isimm=="Ahmet GUR" && yass =="02200201053"){
                                    editor.remove(anahtarisim)
                                    editor.remove(anahtaryas)
                                    editor.remove(unutma)
                                        .commit()
                                    var gecis = Intent(this@fragmentekran,Anaekran::class.java)
                                    startActivity(gecis)
                                }
                            }
                        })
                        sifre.addTextChangedListener(object : TextWatcher {
                            override fun afterTextChanged(p0: Editable?) {
                            }
                            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                            }
                            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                                var isimm = isim.text.toString()
                                var yass = sifre.text.toString()
                                if(isimm=="Ahmet GUR" && yass =="02200201053"){
                                    editor.remove(anahtarisim)
                                    editor.remove(anahtaryas)
                                    editor.remove(unutma)
                                        .commit()
                                    var gecis = Intent(this@fragmentekran,Anaekran::class.java)
                                    startActivity(gecis)
                                }
                            }
                        })
                        ozeluyaripenceresi.create().show()
                        true

                    }

                    else -> false

                }

            }

            acilirmenu.show()
        }

    }
}