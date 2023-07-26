package com.example.odevfinal

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView
import com.google.android.material.snackbar.Snackbar
import org.w3c.dom.Text

class snackf : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var snackf = inflater.inflate(R.layout.fragment_snackf,container,false)


        var mesaj = snackf.findViewById<EditText>(R.id.mesaj)
        var actionisim = snackf.findViewById<EditText>(R.id.actionisim)
        var spinner = snackf.findViewById<Spinner>(R.id.spinner)
        var yazi =snackf.findViewById<TextView>(R.id.textt)

        var dizi = arrayOf("Süre Seçiniz","2sn","2.5sn","3sn","3.5sn","4sn")

        var adapter = ArrayAdapter(snackf.context,android.R.layout.simple_dropdown_item_1line,dizi)

        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2==0){
                    yazi.text = ""
                }else if(p2==1) {
                    Snackbar.make(snackf,mesaj.text, 2000)
                        .setAction(actionisim.text){
                            Toast.makeText(snackf.context,actionisim.text,Toast.LENGTH_SHORT).show()
                        }.show()
                }
                else if(p2==2) {
                    Snackbar.make(snackf,mesaj.text, 2500)
                        .setAction(actionisim.text){
                            Toast.makeText(snackf.context,actionisim.text,Toast.LENGTH_SHORT).show()
                        }.show()
                }
                else if(p2==3) {
                    Snackbar.make(snackf,mesaj.text, 3000)
                        .setAction(actionisim.text){
                            Toast.makeText(snackf.context,actionisim.text,Toast.LENGTH_SHORT).show()
                        }.show()
                }
                else if(p2==4) {
                    Snackbar.make(snackf,mesaj.text, 3500)
                        .setAction(actionisim.text){
                            Toast.makeText(snackf.context,actionisim.text,Toast.LENGTH_SHORT).show()
                        }.show()

                }
                else{
                    Snackbar.make(snackf,mesaj.text, 4000)
                        .setAction(actionisim.text){
                            Toast.makeText(snackf.context,actionisim.text,Toast.LENGTH_SHORT).show()
                        }.show()
                }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        mesaj.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var mesaj = mesaj.text.toString()
                var actionisim = actionisim.text.toString()
            }
        })
        actionisim.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var mesaj = mesaj.text.toString()
                var actionisim = actionisim.text.toString()
            }
        })


        return snackf
    }


}

//yazi.text = "${dizi[p2]} Seçili"