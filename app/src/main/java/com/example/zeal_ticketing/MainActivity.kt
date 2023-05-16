package com.example.zeal_ticketing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var list_events:ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list_events=findViewById(R.id.list_events)

        // Set up click listeners for the Buy Tickets and Sell Tickets buttons
        val btnBuyTickets = findViewById<Button>(R.id.btn_buy_tickets)
        val btnSellTickets = findViewById<Button>(R.id.btn_sell_tickets)
        btnBuyTickets.setOnClickListener {
            // TODO: Implement logic for buying tickets

                // Get the selected event from the list view
                val selectedItem = list_events.selectedItem as? String
                if (selectedItem == null) {
                    Toast.makeText(this, "Please select an event to buy tickets for", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                // TODO: Implement logic for buying tickets for the selected event






                Toast.makeText(this, "You bought tickets for $selectedItem", Toast.LENGTH_SHORT).show()





        }
        btnSellTickets.setOnClickListener {
            // TODO: Implement logic for selling tickets



            // Get the selected event from the list view
                val selectedItem = list_events.selectedItem as? String
                if (selectedItem == null) {
                    Toast.makeText(this, "Please select an event to sell tickets for", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                // TODO: Implement logic for selling tickets for the selected event
                Toast.makeText(this, "You sold tickets for $selectedItem", Toast.LENGTH_SHORT).show()




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
