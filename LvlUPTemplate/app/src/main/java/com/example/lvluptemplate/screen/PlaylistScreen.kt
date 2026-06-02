package com.example.lvluptemplate.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
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
import com.example.lvluptemplate.components.AddPlaylistCard
import com.example.lvluptemplate.components.CreatePlaylistDialog
import com.example.lvluptemplate.components.MiniPlayerComponent
import com.example.lvluptemplate.components.PlaylistCardComponent
import com.example.lvluptemplate.components.SimpleBottomBar

data class Playlist(
    val id: Int,
    val name: String,
    val tracksCount: Int
)

@Composable
fun PlaylistsScreen(
    navController: NavController
) {

    var showDialog by remember {
        mutableStateOf(false)
    }

    var playlists by remember {
        mutableStateOf(
            listOf(
                Playlist(1, "Daily Drive", 45),
                Playlist(2, "Cyberpunk Beats", 28),
                Playlist(3, "Chill Gaming", 60),
                Playlist(4, "Elektro Sessions", 19)
            )
        )
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
                .padding(horizontal = 16.dp)
                .padding(paddingValues)
        ) {

            Text(
                text = "Your Playlists",
                color = Color.White,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(
                    top = 24.dp,
                    bottom = 24.dp
                )
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp),
                modifier = Modifier.fillMaxSize()
            ) {

                item {

                    AddPlaylistCard(
                        onClick = {
                            showDialog = true
                        }
                    )

                    if (showDialog) {

                        CreatePlaylistDialog(
                            onDismiss = {
                                showDialog = false
                            },
                            onPlaylistCreated = { playlistName ->

                                val newPlaylist = Playlist(
                                    playlists.size + 1,
                                    playlistName,
                                    0
                                )

                                playlists = playlists + newPlaylist

                                showDialog = false
                            }
                        )
                    }
                }

                items(playlists) { playlist ->

                    PlaylistCardComponent(
                        playlist = playlist,

                        onClick = {
                            navController.navigate("myplaylist")
                        }
                    )
                }
            }
        }
    }
}