package com.example.zeal_ticketing

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SellActivity : AppCompatActivity() {

    lateinit var edtsellname:EditText
    lateinit var edtselldescrip:EditText
    lateinit var edtsellprice:EditText
    lateinit var btnsell:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sell)

        edtsellname=findViewById(R.id.sellname)
        edtselldescrip=findViewById(R.id.selldescription)
        edtsellprice=findViewById(R.id.sellprice)
        btnsell=findViewById(R.id.btnsell)

        btnsell.setOnClickListener {
           val intent = Intent()
            intent.putExtra("item", "New item")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }
}