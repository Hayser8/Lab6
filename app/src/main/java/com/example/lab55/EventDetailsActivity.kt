import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lab55.Event
import com.example.lab55.MainActivity
import com.example.lab55.ui.events.model.EventContent
import com.example.lab55.ui.theme.Lab55Theme

class EventDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab55Theme {
                // Debes decidir qué hacer aquí
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventDetails(navController: NavController, eventId: String, events: List<com.example.lab55.Event>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("SecondScreen") },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Arrow Back",
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        }
                    )
                    Spacer(modifier= Modifier.width(8.dp))
                }
            )
        }
    ) {
        EventDetailsContent(navController, eventId, EventContent.events)
    }
}

@Composable
fun EventDetailsContent(navController: NavController, eventId: String, events: List<Event>) {

    val event = events.find { it.id == eventId }

    if (event != null) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Imagen
            Image(
                painter = painterResource(id = event.imageResourceId),
                contentDescription = "Event Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )

            // Titulo del evento
            Text(
                text = event.title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )

            // Fecha y hora del evento
            Text(
                text = "Fecha y Hora: ${event.fechayhora}",
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
            )

            // Sobre el evento
            Text(
                text = "Sobre el Evento:",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )

            // Resumen del evento
            Text(
                text = event.description,
                fontSize = 16.sp,
                modifier = Modifier.padding(16.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            // Botones
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = { /* Acción cuando se presiona Favoritos */ }) {
                    Text(text = "Favoritos")
                }

                Button(onClick = { /* Acción cuando se presiona Comprar */ }) {
                    Text(text = "Comprar")
                }
            }
        }
    } else {
        Text(
            text = "Evento no encontrado",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
    }
}
