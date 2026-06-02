package com.example.lvluptemplate.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun SimpleBottomBar(
    navController: NavController
) {

    NavigationBar(
        containerColor = Color.Black
    ) {

        NavigationBarItem(
            selected = false,

            onClick = {
                navController.navigate("main")
            },

            icon = {
                Icon(
                    Icons.Default.Home,
                    contentDescription = "Home",
                    tint = Color.White
                )
            },

            label = {
                Text(
                    "Home",
                    color = Color.White
                )
            }
        )

        NavigationBarItem(
            selected = false,

            onClick = {
                navController.navigate("search")
            },

            icon = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color.White
                )
            },

            label = {
                Text(
                    "Search",
                    color = Color.White
                )
            }
        )

        NavigationBarItem(
            selected = false,

            onClick = {
                navController.navigate("playlist")
            },

            icon = {
                Icon(
                    Icons.Default.List,
                    contentDescription = "Playlist",
                    tint = Color.White
                )
            },

            label = {
                Text(
                    "Playlist",
                    color = Color.White
                )
            }
        )
    }
}