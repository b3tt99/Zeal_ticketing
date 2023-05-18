package com.example.zeal_ticketing

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var list_events: ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list_events = findViewById(R.id.list_events)

        // Set up click listeners for the Buy Tickets and Sell Tickets buttons
        val btnBuyTickets = findViewById<Button>(R.id.btn_buy_tickets)
        val btnSellTickets = findViewById<Button>(R.id.btn_sell_tickets)
        btnBuyTickets.setOnClickListener {
            var gotobuy = Intent(this, BuyActivity::class.java)
            startActivity(gotobuy)
        }
        btnSellTickets.setOnClickListener {
            var gotosell = Intent(this, SellActivity::class.java)
            startActivity(gotosell)

        }

        // Set up the ListView for browsing events

        val events = listOf("Concert", "Theater Show", "Sports Game")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, events)
        list_events.adapter = adapter
        list_events.setOnItemClickListener { _, _, position, _ ->
            val selectedEvent = adapter.getItem(position)
            Toast.makeText(this, "Selected event: $selectedEvent", Toast.LENGTH_SHORT).show()
            // TODO: Implement logic for displaying event details

            val intent = Intent(this, EventDetailsActivity::class.java)
            intent.putExtra("event_name", selectedEvent)
            startActivity(intent)



        }

    }


}


