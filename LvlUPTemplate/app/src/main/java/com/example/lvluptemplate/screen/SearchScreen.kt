package com.example.lvluptemplate.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lvluptemplate.components.MiniPlayerComponent
import com.example.lvluptemplate.components.SimpleBottomBar
import com.example.lvluptemplate.components.Song
import com.example.lvluptemplate.components.SongResultRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    navController: NavController
) {

    var searchQuery by remember {
        mutableStateOf("")
    }

    val songs = listOf(

        Song(
            "Blinding Lights",
            "The Weeknd",
            "After Hours",
            "Synthwave"
        ),

        Song(
            "Starboy",
            "The Weeknd",
            "Starboy",
            "R&B"
        ),

        Song(
            "505",
            "Arctic Monkeys",
            "Favourite Worst Nightmare",
            "Indie Rock"
        ),

        Song(
            "Sweater Weather",
            "The Neighbourhood",
            "I Love You",
            "Alternative"
        ),

        Song(
            "After Dark",
            "Mr.Kitty",
            "Time",
            "Synthwave"
        ),

        Song(
            "Requiem",
            "Keshi",
            "Gabriel",
            "Lo-fi"
        )
    )
    val filteredSongs = songs.filter {

        it.title.contains(searchQuery, true) ||

                it.artist.contains(searchQuery, true) ||

                it.album.contains(searchQuery, true) ||

                it.genre.contains(searchQuery, true)
    }

    Scaffold(
        bottomBar = {
            Column {
                MiniPlayerComponent()
                SimpleBottomBar(navController)
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(paddingValues)
                .padding(16.dp)
        ) {

            Text(
                text = "Search",
                color = Color.White,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = searchQuery,

                onValueChange = {
                    searchQuery = it
                },

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),

                placeholder = {
                    Text(
                        "Artists or songs...",
                        color = Color.Gray
                    )
                },

                leadingIcon = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "Search Icon",
                        tint = Color.Gray
                    )
                },

                singleLine = true,

                shape = RoundedCornerShape(12.dp),

                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFF151515),
                    unfocusedContainerColor = Color(0xFF151515),
                    focusedBorderColor = Color(0xFF7E49C3),
                    unfocusedBorderColor = Color(0xFF2C2C2C),
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                )
            )

            LazyColumn {

                items(filteredSongs) { song ->

                    SongResultRow(
                        song = song,

                        onClick = {
                            navController.navigate("song")
                        }
                    )
                }
            }
        }
    }
}