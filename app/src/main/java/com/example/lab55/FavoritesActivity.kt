import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab55.R
import com.example.lab55.ui.theme.Lab55Theme
import androidx.compose.ui.graphics.RectangleShape

data class EventoFavorito(val titulo: String, val ubicacion: String, val idImagen: Int)

class MisFavoritosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab55Theme {
                ContenidoFavoritos()
            }
        }
    }
}

@Composable
fun ContenidoFavoritos() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp), // Reducir el espaciado
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Tus favoritos",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Estos son tus eventos favoritos",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        val eventosFavoritos = listOf(
            EventoFavorito("Concierto de Bad Bunny", "Cardales", R.drawable.event_image_1_background),
            EventoFavorito("Concierto de Humbe", "Cardales", R.drawable.event_image_2_background),
            EventoFavorito("Concierto de EDM", "Parque de la industria", R.drawable.event_image_3_background),
            EventoFavorito("Concierto de Wos", "Majadas", R.drawable.event_image_4_background)
        )

        eventosFavoritos.forEachIndexed { index, evento ->
            TarjetaEventoFavorito(evento, index + 1)
        }
    }
}

@Composable
fun TarjetaEventoFavorito(evento: EventoFavorito, numero: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(135.dp) // Altura fija para hacer las tarjetas rectangulares
            .padding(8.dp), // Añadir espacio interno
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RectangleShape // Hacer esquinas cuadradas
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = evento.idImagen),
                contentDescription = "Imagen del Evento",
                modifier = Modifier
                    .size(100.dp) // Tamaño de la imagen
                    .clip(shape = RectangleShape) // Hacer esquinas cuadradas con RectangleShape
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = "$numero. ${evento.titulo}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = evento.ubicacion,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}
