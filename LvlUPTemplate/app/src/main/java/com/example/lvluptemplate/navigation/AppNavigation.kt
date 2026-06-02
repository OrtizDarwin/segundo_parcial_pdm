package com.example.lvluptemplate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lvluptemplate.screen.MainScreen
import com.example.lvluptemplate.screen.MyPlaylistScreen
import com.example.lvluptemplate.screen.PlaylistsScreen
import com.example.lvluptemplate.screen.SearchScreen
import com.example.lvluptemplate.screen.SongDetailScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "main"
    ) {

        composable("main") {
            MainScreen(navController)
        }

        composable("search") {
            SearchScreen(navController)
        }

        composable("playlist") {
            PlaylistsScreen(navController)
        }

        composable("song") {
            SongDetailScreen(navController)
        }

        composable("myplaylist") {
            MyPlaylistScreen(navController)
        }
    }
}