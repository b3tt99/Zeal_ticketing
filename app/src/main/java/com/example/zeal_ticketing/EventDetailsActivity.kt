package com.example.zeal_ticketing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class EventDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_details)

        // Get the event name and description from the intent extras
        val eventName = intent.getStringExtra("event_name")
        val eventDescription = intent.getStringExtra("event_description")

        // Display the event name and description in the appropriate UI elements
        val tvEventName = findViewById<TextView>(R.id.tv_event_name)
        tvEventName.text = eventName

        val tvEventDescription = findViewById<TextView>(R.id.tv_event_description)
        tvEventDescription.text = eventDescription
    }
}