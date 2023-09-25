package com.example.lab55.ui.events.model

import com.example.lab55.Event
import com.example.lab55.R

data class Event(val title: String, val description: String, val imageResourceId: Int, val id: String, val fechayhora: String)
class EventContent{
    companion object{
        val events = listOf(
            Event("Concierto de Bad Bunny", "Pasa una noche increíble escuchando Bad Bunny", R.drawable.event_image_1_background, "1", "30 de septiembre 10: 00 am"),
            Event("Concierto de Humbe", "Pasa una noche increíble escuchando Humbe", R.drawable.event_image_2_background, "2", "29 de septiembre 10: 00 am"),
            Event("Concierto de Electrónica", "Pasa una noche increíble escuchando música electrónica", R.drawable.event_image_3_background, "3", "28 de septiembre 10: 00 am"),
            Event("Concierto de Wos", "Pasa una noche increíble escuchando Wos", R.drawable.event_image_4_background, "4", "27 de septiembre 10: 00 am")
        )
    }
}
