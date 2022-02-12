package com.example.mandat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import  com.example.mandat.WesternUnion
import java.util.*

class Confirmation_Mandat : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation_mandat)

        val expediteur = findViewById<TextView>(R.id.expediteur) as TextView
        val type = findViewById<TextView>(R.id.type) as TextView
        val codeOperation: TextView = findViewById<TextView>(R.id.codeOperation) as TextView
        val Pays = findViewById<TextView>(R.id.Pays) as TextView
        val date = findViewById<TextView>(R.id.date) as TextView
        val total = findViewById<TextView>(R.id.total) as TextView
        val button5 = findViewById<Button>(R.id.button5) as Button
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
          Toast.makeText(this,"validation terminer ",Toast.LENGTH_SHORT).show()
      }

    }
}