package com.example.zeal_ticketing

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class BuyActivity : AppCompatActivity() {

    lateinit var buyEname:EditText
    lateinit var buyEprice:EditText
    lateinit var btnEpurchase:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy)

        buyEname=findViewById(R.id.buyEname)
        buyEprice=findViewById(R.id.buyEprice)
        btnEpurchase=findViewById(R.id.buybtnpurchase)

        btnEpurchase.setOnClickListener {
            val url = "https://www.payment-provider.com/pay"
            val intent= Intent(Intent.ACTION_VIEW, Uri.parse(url))

            startActivity(intent)
        }

    }
}