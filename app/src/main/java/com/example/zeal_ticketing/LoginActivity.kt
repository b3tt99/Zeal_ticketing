package com.example.zeal_ticketing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var ledt_email:EditText
    private lateinit var ledt_password:EditText
    private lateinit var lbtn_login:Button
    private lateinit var lbtn_register:Button

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        ledt_email = findViewById(R.id.lemailaddress)
        ledt_password = findViewById(R.id.lpassword)
        lbtn_login = findViewById(R.id.llogin)
        lbtn_register = findViewById(R.id.lcreate_account)

        auth= FirebaseAuth.getInstance()

        lbtn_register.setOnClickListener {

            var gotoreg = Intent(this, RegisterActivity::class.java)
            startActivity(gotoreg)

        }
        lbtn_login.setOnClickListener {
            var email=ledt_email.text.toString().trim()
            var password=ledt_password.text.toString().trim()

            //validate
            if (email.isEmpty()||password.isEmpty()){
                Toast.makeText(this, "Cannot submit empty field(s)", Toast.LENGTH_SHORT).show()
            }else{
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){
                    if (it.isSuccessful){
                        Toast.makeText(this, "Logged In Successfully", Toast.LENGTH_SHORT).show()

                        var gotomain = Intent(this, MainActivity::class.java)
                        startActivity(gotomain)
                        finish()


                    }else{
                        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }



    }
}