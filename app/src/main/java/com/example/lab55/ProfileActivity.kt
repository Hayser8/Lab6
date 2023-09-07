import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab55.R
import com.example.lab55.ui.theme.Lab55Theme

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab55Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    ProfileContent()
                }
            }
        }
    }
}

@Composable
fun ProfileContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.event_image_6_background),
                contentDescription = "Profile Background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.event_image_7_background),
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Nombre de Usuario",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
        Spacer(modifier = Modifier.weight(0.1f))
        val profileCardItems = listOf(
            ProfileCardItem("Editar perfil", R.drawable.event_image_7_background, false, false),
            ProfileCardItem("Reiniciar Contraseña", R.drawable.event_image_8_background, false, false),
            ProfileCardItem("Notificaciones", R.drawable.event_image_7_background, true, false),
            ProfileCardItem("Favoritos", R.drawable.event_image_9_background, false, false)
        )

        profileCardItems.forEach { cardItem ->
            ProfileCardItem(cardItem)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}











data class ProfileCardItem(
    val title: String,
    val imageResourceId: Int,
    val hasToggleButton: Boolean,
    var isChecked: Boolean // Agregar isChecked aquí
)



@Composable
fun ProfileCardItem(cardItem: ProfileCardItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = cardItem.imageResourceId),
                contentDescription = "Card Image",
                modifier = Modifier
                    .size(20.dp)
                    .clip(shape = RoundedCornerShape(4.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = cardItem.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
                if (cardItem.hasToggleButton) {
                    Spacer(modifier = Modifier.height(8.dp))
                    ToggleButton(isChecked = cardItem.isChecked) { newCheckedState ->
                        cardItem.isChecked = newCheckedState
                    }
                }
            }
        }
    }
}



@Composable
fun ToggleButton(isChecked: Boolean, onToggle: (Boolean) -> Unit) {
    Switch(
        checked = isChecked,
        onCheckedChange = {
            onToggle(!isChecked) // Cambiamos el valor del estado
        },
        modifier = Modifier
            .background(Color.LightGray, CircleShape)
            .padding(4.dp)
    )
}



