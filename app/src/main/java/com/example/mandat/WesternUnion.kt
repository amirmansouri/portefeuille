package com.example.mandat

import android.content.pm.PackageManager
import android.graphics.pdf.PdfDocument
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

import com.itextpdf.text.Document
import com.itextpdf.text.Paragraph
import com.itextpdf.text.pdf.PdfWriter
import java.io.FileOutputStream
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*
import java.util.Calendar.getInstance
import org.w3c.dom.Document as Document1


class WesternUnion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_western_union)
        val buttonW = findViewById<Button>(R.id.buttonW) as Button
        val codeW = findViewById<EditText>(R.id.codeW) as EditText
        val pinw = findViewById<EditText>(R.id.pinW) as EditText
        val montantw = findViewById<TextView>(R.id.montantW) as TextView
        val radioButton = findViewById<RadioButton>(R.id.radioButton) as RadioButton

        var database = FirebaseDatabase.getInstance().getReference("Users")

        database.child("amir").get().addOnSuccessListener {
            val montant2 = it.child("mandat").value
            montantw.text = montant2.toString()

        }
        buttonW.setOnClickListener {
            if (radioButton.isChecked == false) {

                Toast.makeText(this, "checked w ija se3a", Toast.LENGTH_SHORT).show()
            }
            val code = codeW.text.toString()
            val pin = pinw.text.toString()
            val montant = montantw.text.toString()
            if (code.isNotEmpty()) {
                readData(code, pin, montant)

            } else {

            }
            


        }
    }


    private fun readData(code: String, pin: String, montant: String) {
        var database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(code).get().addOnSuccessListener {
            val radioButton = findViewById<RadioButton>(R.id.radioButton) as RadioButton


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

    private fun pdf(code: String, button: Button) {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_DENIED
            ) {
                val permission = arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                val STORAGE_CODE = 1001
                requestPermissions(permission, STORAGE_CODE)
            } else {
                savePDF();
            }
        }
    }

    private fun savePDF() {
  val mDoc= Document()
        val mFileName = SimpleDateFormat("yyyMMdd_HHmmss",Locale.getDefault())
            .format(System.currentTimeMillis())
        val mFilePath = Environment.getExternalStorageDirectory().toString() + "/"+".pdf"
  try {
      //PdfWriter.getInstance(mDoc,FileOutputStream(mFilePath))
      PdfWriter.getInstance(mDoc,FileOutputStream(mFilePath))
          mDoc.open()
      val codeW= findViewById<EditText>(R.id.codeW) as EditText
      val data = codeW.text.toString().trim()
      mDoc.addAuthor("KB CODER")
      mDoc.add(Paragraph(data))
      mDoc.close()
      Toast.makeText(this,"$mFileName.pdf \n is create to \n",Toast.LENGTH_SHORT).show()


  }catch (e: Exception){
      Toast.makeText(this,""+e.toString(),Toast.LENGTH_SHORT).show()

  }
    }




}









