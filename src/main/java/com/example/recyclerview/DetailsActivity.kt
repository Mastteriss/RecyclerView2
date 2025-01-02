package com.example.recyclerview


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout


class DetailsActivity : AppCompatActivity() {
    private lateinit var layoutCL:ConstraintLayout
    private lateinit var displayNameTV:TextView
    private lateinit var displayInfoTV:TextView
    private lateinit var displayImageViewIV:ImageView
    private lateinit var toolbar: Toolbar



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        layoutCL = findViewById(R.id.layoutCL)
        toolbar = findViewById(R.id.toolbar)
        displayNameTV = findViewById(R.id.displayNameTV)
        displayInfoTV = findViewById(R.id.displayInfoTV)
        displayImageViewIV = findViewById(R.id.displayImageViewIV)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener{
            onBackPressed()
        }

        var garderob:Garderob? = null
        if(intent.hasExtra("garderob")){
            Log.d("DetailsActivity", "Received user: $garderob")
            garderob = intent.getSerializableExtra("garderob")as Garderob
        }
        if(garderob!= null){
            displayNameTV.text = garderob.name
            displayInfoTV.text = garderob.info
            displayImageViewIV.setImageResource(garderob.image)
        }

        layoutCL.setOnLongClickListener{
            val dialog = AlertDialog.Builder(this)
            val inflater = this.layoutInflater
            val dialogView = inflater.inflate(R.layout.update_dialog, null)
            dialog.setView(dialogView)
            val editName = dialogView.findViewById(R.id.updateNameET)as EditText
            val editInfo = dialogView.findViewById(R.id.updateInfoET)as EditText

            dialog.setTitle("Обновить запись")
            dialog.setMessage("Введите данные ниже")
            dialog.setPositiveButton("Обновить"){_,_ ->
                displayNameTV.text = editName.text.toString()
                displayInfoTV.text = editInfo.text.toString()
                val garderob = Garderob(displayNameTV.text.toString(), displayNameTV.text.toString(), R.drawable.ic_launcher_foreground)


            }

            dialog.setNegativeButton("Отмена"){_,_ ->

            }
            dialog.create().show()
            false
        }

    }

}