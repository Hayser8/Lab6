import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab55.R
import com.example.lab55.ui.theme.Lab55Theme

class EventDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab55Theme {
                EventDetailsContent()
            }
        }
    }
}

@Composable
fun EventDetailsContent() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Imagen
        Image(
            painter = painterResource(id = R.drawable.event_image_1_background), // Cambiar por tu imagen
            contentDescription = "Event Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        // Titulo del evento
        Text(
            text = "Concierto de Bad Bunny",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        // Fecha y hora del evento
        Text(
            text = "Fecha y Hora: 12 de agosto, 2023 a las 15:00",
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
            text = "¡Ven y únete a nosotros para un evento emocionante lleno de diversión!",
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
            Button(
                onClick = { /* Acción cuando se presiona Favoritos */ }
            ) {
                Text(text = "Favoritos")
            }

            Button(
                onClick = { /* Acción cuando se presiona Comprar */ }
            ) {
                Text(text = "Comprar")
            }
        }
    }
}
