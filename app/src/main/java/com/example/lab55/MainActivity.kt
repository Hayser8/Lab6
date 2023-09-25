package com.example.lab55

import ContenidoFavoritos
import EventDetailsContent
import EventListContent


import ProfileContent
import android.annotation.SuppressLint


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab55.navigation.AppNavigation
import com.example.lab55.navigation.AppScreens
import com.example.lab55.ui.events.view.EventList
import com.example.lab55.ui.theme.Lab55Theme

data class Event(val title: String, val description: String, val imageResourceId: Int, val id: String, val fechayhora: String)


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
                //TodoEventoApp()
                AppNavigation()


            }
        }
    }
    companion object{
        val events = listOf(
            Event("Concierto de Bad Bunny", "Pasa una noche increíble escuchando Bad Bunny", R.drawable.event_image_1_background, "1", "30 de septiembre 10: 00 am"),
            Event("Concierto de Humbe", "Pasa una noche increíble escuchando Humbe", R.drawable.event_image_2_background, "2", "29 de septiembre 10: 00 am"),
            Event("Concierto de Electrónica", "Pasa una noche increíble escuchando música electrónica", R.drawable.event_image_3_background, "3", "28 de septiembre 10: 00 am"),
            Event("Concierto de Wos", "Pasa una noche increíble escuchando Wos", R.drawable.event_image_4_background, "4", "27 de septiembre 10: 00 am")
        )
    }
}



enum class TabScreen { Eventos, Lugares, Perfil, Favoritos }
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun TodoEventoApp(navController: NavHostController) {
    var selectedTab by remember { mutableStateOf<TabScreen>(TabScreen.Eventos) }

    val tabs = TabScreen.values()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "TodoEvento+",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            )
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                when (selectedTab) {
                    TabScreen.Eventos -> EventList(navController)
                    TabScreen.Lugares -> PlaceList()
                    TabScreen.Perfil -> Profile()
                    TabScreen.Favoritos -> Favorites()
                    else -> {}
                }
            }
        },

        bottomBar = {
            BottomAppBar(
            ) {
                BottomNavigation(
                    modifier = Modifier.height(56.dp), // Ajusta la altura del BottomNavigation
                ) {
                    tabs.forEach { tab ->
                        BottomNavigationItem(
                            selected = tab == selectedTab,
                            onClick = { selectedTab = tab },
                            icon = {
                                val iconResource = when (tab) {
                                    TabScreen.Eventos -> R.drawable.ic_home
                                    TabScreen.Lugares -> R.drawable.ic_place
                                    TabScreen.Perfil -> R.drawable.ic_person
                                    TabScreen.Favoritos -> R.drawable.ic_favorites
                                }

                                Image(
                                    painter = painterResource(id = iconResource),
                                    contentDescription = null,
                                    modifier = Modifier.size(24.dp)
                                )
                            },
                            label = { Text(text = tab.name) }
                        )
                    }
                }
            }
        }
    )
}





@Composable
fun Favorites(){
    ContenidoFavoritos()
}

@Composable
fun PlaceList() {
    EventListContent()
}

@Composable
fun Profile() {
    ProfileContent()
}


//@Composable
//fun EventList(navController: NavHostController) {
//
//
//    val chunkedEvents = MainActivity.events.chunked(2)
//
//    Column(
//        modifier = Modifier
//            .padding(top = 46.dp) // Agrega un margen superior
//            .fillMaxSize()
//    ) {
//        chunkedEvents.forEach { rowEvents ->
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceEvenly
//            ) {
//                rowEvents.forEach { event ->
//                    EventCard(event = event, navController)
//                }
//            }
//            Spacer(modifier = Modifier.height(16.dp))
//        }
//    }
//}


//@Composable
//fun EventCard(event: Event, navController: NavHostController) {
//    Card(
//        modifier = Modifier
//            .width(180.dp)
//            .clickable {
//                navController.navigate(route = "${AppScreens.EventDetailsActivity.route}/${event.id}")
//            },
//        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
//    ) {
//        Column(
//            modifier = Modifier.padding(16.dp)
//        ) {
//            Image(
//                painter = painterResource(id = event.imageResourceId),
//                contentDescription = "Event Image",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(120.dp)
//                    .clip(shape = RoundedCornerShape(4.dp))
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(
//                text = event.title,
//                fontSize = 18.sp,
//                fontWeight = FontWeight.Bold,
//            )
//            Spacer(modifier = Modifier.height(4.dp))
//            Text(
//                text = event.description,
//                fontSize = 14.sp,
//                color = Color.Gray
//            )
//        }
//    }
//}

