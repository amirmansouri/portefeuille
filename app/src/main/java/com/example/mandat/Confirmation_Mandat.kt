package com.example.mandat

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import  com.example.mandat.WesternUnion
import java.util.*

class Confirmation_Mandat : AppCompatActivity() {

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation_mandat)
val layoutInflater : LayoutInflater = layoutInflater
        val  viewLay = layoutInflater.inflate(R.layout.valid,findViewById(R.id.valid_))
        val expediteur = findViewById<TextView>(R.id.expediteur) as TextView
        val type = findViewById<TextView>(R.id.type) as TextView
        val codeOperation: TextView = findViewById<TextView>(R.id.codeOperation) as TextView
        val Pays = findViewById<TextView>(R.id.Pays) as TextView
        val date = findViewById<TextView>(R.id.date) as TextView
        val total = findViewById<TextView>(R.id.total) as TextView
        val button5 = findViewById<Button>(R.id.button5) as Button
        val progressBar = findViewById<ProgressBar>(R.id.progressBar) as ProgressBar
val intent=intent
        val codeW=intent.getStringExtra("codeW")
        expediteur.text = codeW
      val codeOp = intent.getStringExtra("codeOperateur")
        codeOperation.text=codeOp
        val pays = intent.getStringExtra("pays")
        Pays.text=pays
        date.text = Calendar.getInstance().time.toString()
        val montant = intent.getStringExtra("montant")
        total.text = montant
      button5.setOnClickListener{
         var bar = 0
        Thread(Runnable {
              while (bar <100){
                  bar +=1
                  try {
                      Thread.sleep(20)
                     progressBar.setProgress(bar)
                  }
                  catch (exp:InterruptedException){
                      exp.printStackTrace()
                  }
                  }
          }).start()

val valid = Toast.makeText(this,"",Toast.LENGTH_SHORT)
          valid.setGravity(Gravity.CENTER,0,0)
          valid.view=viewLay
          valid.show()
      }

    }
}