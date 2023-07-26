package com.example.odevfinal

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


val dosyayolu = "com.example.onbirincihaftaders"
val anahtarisim = "isim"
val anahtaryas = "yas"
var unutma = "unutma"


class Anaekran : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anaekran)

        var isim = findViewById<EditText>(R.id.name)
        var yas = findViewById<EditText>(R.id.passw)
        var hatir = findViewById<Switch>(R.id.hatirla)
        var prog = findViewById<ProgressBar>(R.id.progressBar2)

        var preferences = getSharedPreferences(dosyayolu, Context.MODE_PRIVATE)
        var editor = preferences.edit()


        Toast.makeText(applicationContext,
        "Kaydedilmiş \n İsim : ${preferences.getString(anahtarisim,"Değer yok")} \n " +
        "Şifre : ${preferences.getString(anahtaryas,"Değer yok")} \n " +
                "Unutma : ${preferences.getString(unutma,"false")}",Toast.LENGTH_SHORT).show()


        if(preferences.getString(anahtarisim,"")=="Ahmet GUR"){
            isim.setText("Ahmet GUR")
        }
        if(preferences.getString(anahtaryas,"")=="02200201053"){
            yas.setText("02200201053")
        }
        if(preferences.getString(anahtarisim,"")=="Ahmet GUR" && preferences.getString(anahtaryas,"")=="02200201053"){
            Handler().postDelayed({
                var gecis = Intent(this@Anaekran,fragmentekran::class.java)
                startActivity(gecis)
            },2000)
        }


        isim.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var isimm = isim.text.toString()
                var yass = yas.text.toString()
                if(isimm=="Ahmet GUR" && yass =="02200201053"){
                    if (hatir.isChecked()== true) {
                        prog.visibility = View.VISIBLE
                        var unutmaa = "true"
                        editor.putString(unutma,unutmaa.toString())
                        editor.putString(anahtarisim,isimm.toString())
                        editor.putString(anahtaryas,yass.toString())
                        editor.apply()
                        var gecis = Intent(this@Anaekran,fragmentekran::class.java )
                        startActivity(gecis)
                    } else{
                        prog.visibility = View.VISIBLE
                        var unutmaa = "false"
                        editor.putString(unutma,unutmaa.toString())
                        editor.remove(anahtarisim)
                        editor.remove(anahtaryas)
                        editor.apply()
                        var gecis = Intent(this@Anaekran,fragmentekran::class.java )
                        startActivity(gecis)

                    }
                }
            }
        })

        yas.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var isimm = isim.text.toString()
                var yass = yas.text.toString()
                if(isimm=="Ahmet GUR" && yass =="02200201053"){
                        if (hatir.isChecked()== true) {
                            prog.visibility = View.VISIBLE
                            var unutmaa = "true"
                            editor.putString(unutma,unutmaa.toString())
                            editor.putString(anahtarisim,isimm.toString())
                            editor.putString(anahtaryas,yass.toString())
                            editor.apply()
                            var gecis = Intent(this@Anaekran,fragmentekran::class.java )
                            startActivity(gecis)
                        } else{
                            prog.visibility = View.VISIBLE
                            var unutmaa = "false"
                            editor.putString(unutma,unutmaa.toString())
                            editor.remove(anahtarisim)
                            editor.remove(anahtaryas)
                            editor.apply()
                            var gecis = Intent(this@Anaekran,fragmentekran::class.java )
                            startActivity(gecis)
                        }
                }
            }
        })

    }
}