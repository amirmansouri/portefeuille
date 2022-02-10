package com.example.mandat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.get
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.lang.reflect.Array.get


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button) as Button
        val txt = findViewById(R.id.txt) as TextView
        val sp_parent = findViewById<Spinner>(R.id.spinner) as Spinner
        val sp_child = findViewById<Spinner>(R.id.spinner2) as Spinner
        val nature_mandat = arrayOf("Mandat national", "Mandat organisme", "Mandat International")
        val Mandat_national = arrayOf("Mandat minute", "Mandat ordinaire")
        val Mandat_organisme = arrayOf("Mandat Bourse", "Mandat CNSS-CNRPS-CNAM")
        val Mandat_International = arrayOf("Western Union", "Post Transfert")



        var arrayAdapter = ArrayAdapter(
            this@MainActivity,
            android.R.layout.simple_spinner_dropdown_item,
            nature_mandat
        )
        var arrayAdapter2 = ArrayAdapter(
            this@MainActivity, android.R.layout.simple_spinner_dropdown_item,
            nature_mandat
        )

        sp_parent.adapter = arrayAdapter
        sp_child.setAdapter(arrayAdapter2)


        sp_parent.onItemSelectedListener = object :


            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                txt.text = nature_mandat[position].toString()
                if (position == 0) {
                    arrayAdapter2 = ArrayAdapter(
                        this@MainActivity, android.R.layout.simple_spinner_dropdown_item,
                        Mandat_national
                    )
                    sp_child.adapter = arrayAdapter2

                }
                if (position == 1) {
                    arrayAdapter2 = ArrayAdapter(
                        this@MainActivity, android.R.layout.simple_spinner_dropdown_item,
                        Mandat_organisme
                    )
                    print(position);
                    sp_child.adapter = arrayAdapter2

                }
                if (position == 2) {
                    arrayAdapter2 = ArrayAdapter(
                        this@MainActivity, android.R.layout.simple_spinner_dropdown_item,
                        Mandat_International
                    )
                    sp_child.adapter = arrayAdapter2
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }
        sp_child.onItemSelectedListener = object :


            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (sp_parent.selectedItemPosition == 0 && sp_child.selectedItemPosition == 0) {


                    button.setOnClickListener{
                        Toast.makeText(this@MainActivity, "positon selectionné", Toast.LENGTH_SHORT)
                            .show()
                        intent = Intent(this@MainActivity, MandatMinute::class.java).apply {
                            startActivity(intent);
                        }

                    }


                }
                if(sp_parent.selectedItemPosition==1 && sp_child.selectedItemPosition==1){
                    button.setOnClickListener{

                        intent = Intent(this@MainActivity, BourseActivity::class.java).apply {
                            startActivity(intent);
                        }

                    }

                }

                if(sp_parent.selectedItemPosition==2 && sp_child.selectedItemPosition==0){
                    button.setOnClickListener{

                        intent = Intent(this@MainActivity, WesternUnion::class.java).apply {
                            startActivity(intent);
                        }

                    }

                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

    }
}









