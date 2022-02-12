package com.example.mandat

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.pdf.PdfDocument
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.widget.*
import androidx.annotation.RequiresPermission
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.firebase.database.FirebaseDatabase
import com.itextpdf.text.Document
import com.itextpdf.text.Paragraph
import com.itextpdf.text.pdf.PdfWriter
import java.io.FileOutputStream
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*
import java.util.jar.Manifest


class WesternUnion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_western_union)

        val buttonW = findViewById<Button>(R.id.buttonW) as Button
        val codeW = findViewById<EditText>(R.id.codeW) as EditText
        val pinw = findViewById<EditText>(R.id.pinW) as EditText
        val montantw = findViewById<TextView>(R.id.montantW) as TextView
        var codeOperateur : String = ""
        var pays: String=""
        var montant:String=""
        val radioButton = findViewById<RadioButton>(R.id.radioButton) as RadioButton

//read from Firebase
        buttonW.setOnClickListener{
        var database = FirebaseDatabase.getInstance().getReference("Users")
        database.child("amir").get().addOnSuccessListener {
            val code = codeW.text.toString()
            val pin = pinw.text.toString()
            val montant2 = it.child("mandat").value
            //  montantw.text= montant2.toString()
            montant = montant2.toString()
            val code2 = it.child("codeOperateur").value
            codeOperateur = code2.toString()
            val pays1 = it.child("pays").value
            pays = pays1.toString()

            val intent = Intent(this, Confirmation_Mandat::class.java)
            intent.putExtra("codeOperateur", codeOperateur)
            intent.putExtra("pays", pays)
            intent.putExtra("montant", montant)
            intent.putExtra("codeW",code)
            intent.putExtra("pinW",pin)
            startActivity(intent)

            val montant = montantw.text.toString()
            if (code.isNotEmpty()) {
                val codeOp = ""
                readData(code, pin, montant,codeOp)


            }
         }
        }
      /*  buttonW.setOnClickListener {
/**/

            /**/
            val code = codeW.text.toString()
            val pin = pinw.text.toString()

            val intent = Intent(this,Confirmation_Mandat::class.java)
            intent.putExtra("codeW",code)
            intent.putExtra("pinW",pin)

            startActivity(intent)

            val montant = montantw.text.toString()
            if (code.isNotEmpty()) {
                val codeOp = ""
                readData(code, pin, montant,codeOp)


            }


        }*/
    }






    private fun readData(code: String, pin: String, montant: String,codeOp: String) {
        var database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(code).get().addOnSuccessListener {
            val radioButton = findViewById<RadioButton>(R.id.radioButton) as RadioButton

          val code_Operateur = codeOp
            val code2 = it.child("codeW").value
            val pin2 = it.child("pinW").value
            if (code == code2 && pin == pin2) {
                if (radioButton.isChecked == false) {

                    Toast.makeText(this, "checked w ija se3a", Toast.LENGTH_SHORT).show()
                }
                Toast.makeText(this, "verified successfuly", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, " failed", Toast.LENGTH_SHORT).show()
            }
        }

    }




}









