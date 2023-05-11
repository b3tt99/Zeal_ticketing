package com.example.zeal_ticketing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var redtname:EditText
    private lateinit var redtemail:EditText
    private lateinit var redtphone_number:EditText
    private lateinit var redtpassword:EditText
    private lateinit var rbtnregister:Button

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        redtname = findViewById(R.id.Rname)
        redtemail = findViewById(R.id.Remail)
        redtphone_number = findViewById(R.id.Rphone_no)
        redtpassword = findViewById(R.id.Rpassword)
        rbtnregister = findViewById(R.id.Rcreate_account)

        auth = FirebaseAuth.getInstance()

        rbtnregister.setOnClickListener {


            var name = redtname.text.toString().trim()
            var email = redtemail.text.toString().trim()
            var phone_no =redtphone_number.text.toString().trim()
            var password = redtpassword.text.toString().trim()

            //validate user info

            if (name.isEmpty()||email.isEmpty()||phone_no.isEmpty()||password.isEmpty()){
                Toast.makeText(this, "Cannot submit empty fields", Toast.LENGTH_SHORT).show()
            }else{
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this){
                    if (it.isSuccessful){
                        Toast.makeText(this, "User created successfully", Toast.LENGTH_SHORT).show()

                        //navigate back to login

                        var gotologin = Intent(this, LoginActivity::class.java)
                        startActivity(gotologin)

                    }else{
                        Toast.makeText(this, "Failed to create account", Toast.LENGTH_SHORT).show()
                    }

                }
            }

        }


    }
}