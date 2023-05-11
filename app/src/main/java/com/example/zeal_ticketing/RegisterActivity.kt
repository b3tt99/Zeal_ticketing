package com.example.zeal_ticketing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {

    private lateinit var redtname:EditText
    private lateinit var redtemail:EditText
    private lateinit var redtphone_number:EditText
    private lateinit var redtpassword:EditText
    private lateinit var rbtnregister:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        redtname = findViewById(R.id.Rname)
        redtemail = findViewById(R.id.Remail)
        redtphone_number = findViewById(R.id.Rphone_no)
        redtpassword = findViewById(R.id.Rpassword)
        rbtnregister = findViewById(R.id.Rcreate_account)

        rbtnregister.setOnClickListener {



            Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show()

        var gotologin = Intent(this, LoginActivity::class.java)
            startActivity(gotologin)

        }


    }
}