package com.example.lab55

import ContenidoFavoritos
import EventDetailsContent
import EventListActivity
import EventListContent


import ProfileContent


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab55.ui.theme.Lab55Theme

data class Event(val title: String, val description: String, val imageResourceId: Int)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab55Theme {
                //MainActivityContent()
                //EventListContent()
                //EventDetailsContent()
                //ProfileContent()
                //ContenidoFavoritos()

            }
        }
    }
}

@Composable
fun MainActivityContent() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "TodoEventos+",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))
            EventList()
        }
    }
}

@Composable
fun EventList() {
    val events = remember {
        mutableStateListOf(
            Event("Concierto de Bad Bunny", "Pasa una noche increíble escuchando Bad Bunny", R.drawable.event_image_1_background),
            Event("Concierto de Humbe", "Pasa una noche increíble escuchando Humbe", R.drawable.event_image_2_background),
            Event("Concierto de Electrónica", "Pasa una noche increíble escuchando música electrónica", R.drawable.event_image_3_background),
            Event("Concierto de Wos", "Pasa una noche increíble escuchando Wos", R.drawable.event_image_4_background)
        )
    }

    val chunkedEvents = events.chunked(2)

    Column {
        chunkedEvents.forEach { rowEvents ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                rowEvents.forEach { event ->
                    EventCard(event = event)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun EventCard(event: Event) {
    Card(
        modifier = Modifier
            .width(180.dp)
            .clickable {

            },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = event.imageResourceId),
                contentDescription = "Event Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(shape = RoundedCornerShape(4.dp))
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = event.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = event.description,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}
