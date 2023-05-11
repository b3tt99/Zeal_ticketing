package com.example.zeal_ticketing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {

    private lateinit var ledt_email:EditText
    private lateinit var ledt_password:EditText
    private lateinit var lbtn_login:Button
    private lateinit var lbtn_register:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        ledt_email = findViewById(R.id.lemailaddress)
        ledt_password = findViewById(R.id.lpassword)
        lbtn_login = findViewById(R.id.llogin)
        lbtn_register = findViewById(R.id.lcreate_account)

        lbtn_register.setOnClickListener {

            var gotoreg = Intent(this, RegisterActivity::class.java)
            startActivity(gotoreg)

        }

    }
}