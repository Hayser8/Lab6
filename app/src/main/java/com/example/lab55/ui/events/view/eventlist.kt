package com.example.lab55.ui.events.view

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.lab55.Event
import com.example.lab55.MainActivity
import com.example.lab55.navigation.AppScreens


@Composable
fun EventList(navController: NavHostController) {


    val chunkedEvents = MainActivity.events.chunked(2)

    Column(
        modifier = Modifier
            .padding(top = 46.dp) // Agrega un margen superior
            .fillMaxSize()
    ) {
        chunkedEvents.forEach { rowEvents ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                rowEvents.forEach { event ->
                    EventCard(event = event, navController)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}



